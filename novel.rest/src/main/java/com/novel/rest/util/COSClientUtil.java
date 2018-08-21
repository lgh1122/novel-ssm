package com.novel.rest.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.novel.rest.controller.ChapterController;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

/**
 * @author XiaoLuo
 * @ClassName: com.neusoft.controller.util.COSClientUtil
 * @Description: ${todo}
 * @date 2018/3/12 15:37
 */
public class COSClientUtil {

    public static Logger logger = Logger.getLogger(COSClientUtil.class);

	public static void main(String[] args) {
 		InputStream is =  String2InputStream("23290909323���ϴ�");
		COSClientUtil util = new COSClientUtil();
		String fullFileName = "/key/hello.txt";
		util.uploadFile2Cos(is, fullFileName);
		logger.info("");
		System.out.println(System.currentTimeMillis());
		String str =	util.downCosFile("https://novel01-1252454126.cos.ap-beijing.myqcloud.com/key/hello.txt");
		System.out.println(str);
		util.destory();
		System.out.println(System.currentTimeMillis());
		logger.info("");
	}
	
	//todo ��Щ������Ϣ���е� ��Ѷ�ƶ���洢����̨ ��ȡ
	// �洢ͨ����			�滻���Լ���
	private static   String bucketName = "";
	//secretId 			�滻���Լ���
	private static   String secretId = "";
	// secretKey		        �滻���Լ���
	private static   String secretKey = "";

	// 1 ��ʼ���û������Ϣ(secretId, secretKey)
	private static   COSCredentials cred;
	// 2 ����bucket������, COS����ļ������� https://cloud.tencent.com/document/product/436/6224
	private static   ClientConfig clientConfig ;
	// 3 ����cos�ͻ���
	//private static   COSClient cosClient ;
	
	private COSClient cOSClient;

	public COSClientUtil() {
		cOSClient = new COSClient(cred, clientConfig);
	}
	
	  static  {
		try {
			Properties  props = new Properties();
            InputStreamReader inputStream = new InputStreamReader(
            		COSClientUtil.class.getClassLoader().getResourceAsStream("resource/resource.properties"), "UTF-8");
            props.load(inputStream);
            
            bucketName = props.getProperty("bucketName");
            secretId =   props.getProperty("secretId");
            secretKey =  props.getProperty("secretKey");
            cred = new BasicCOSCredentials(secretId, secretKey);
            clientConfig = new ClientConfig(new Region("ap-beijing"));
            //cOSClient = new COSClient(cred, clientConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	  public static InputStream String2InputStream(String str) {
		    ByteArrayInputStream stream = null;
		    try {
		        stream = new ByteArrayInputStream(str.getBytes("UTF-8"));
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    }
		    return stream;
		}

	/**
	 * ����
	 */
	public void destory() {
		cOSClient.shutdown();
	}

	/**
	 * �ϴ�ͼƬ
	 *
	 * @param url
	 */
	public void uploadImg2Cos(String url) throws Exception {
		File fileOnServer = new File(url);
		FileInputStream fin;
		try {
			fin = new FileInputStream(fileOnServer);
			String[] split = url.split("/");
			this.uploadFile2Cos(fin, split[split.length - 1]);
		} catch (FileNotFoundException e) {
			throw new Exception("ͼƬ�ϴ�ʧ��");
		}
	}

	public String uploadFile2Cos(MultipartFile file) throws Exception {
		if (file.getSize() > 10 * 1024 * 1024) {
			throw new Exception("�ϴ�ͼƬ��С���ܳ���10M��");
		}
		String originalFilename = file.getOriginalFilename();
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = file.getInputStream();
			this.uploadFile2Cos(inputStream, name);
			return name;
		} catch (Exception e) {
			throw new Exception("ͼƬ�ϴ�ʧ��");
		}
	}

	/**
	 * ���ͼƬ·��
	 *
	 * @param fileUrl
	 * @return
	 */
	public String getImgUrl(String fileUrl) {
		return getUrl(fileUrl);
	}

	/**
	 * ���url����
	 *
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		// ����URL����ʱ��Ϊ10�� 3600l* 1000*24*365*10
		Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
		// ����URL
		URL url = cOSClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}
	
	
	
	public String uploadFile2Cos(String context , String fileName){
		InputStream is =  String2InputStream(context);
		String ret = uploadFile2Cos(is, fileName);
		return ret;
	}

	/**
	 * �ϴ���COS������ ���ͬ���ļ��Ḳ�Ƿ������ϵ�
	 *
	 * @param instream
	 *            �ļ���
	 * @param fileName
	 *            �ļ����� ������׺��
	 * @return ������"" ,ΨһMD5����ǩ��
	 */
	public String uploadFile2Cos(InputStream instream, String fileName) {
		String ret = "";
		try {
			// �����ϴ�Object��Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// �ϴ��ļ�
			PutObjectResult putResult = cOSClient.putObject(bucketName,  fileName, instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Description: �ж�Cos�����ļ��ϴ�ʱ�ļ���contentType
	 *
	 * @param filenameExtension �ļ���׺
	 * @return String
	 */
	public static String getcontentType(String filenameExtension) {
		if (filenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		}
		if (filenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		}
		if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
				|| filenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		}
		if (filenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (filenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		}
		if (filenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		}
		if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		}
		if (filenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		}
		return "image/jpeg";
	}
	public String  downCosFile(String fullFileName){
		 try {
	            URL url = new URL(fullFileName);
	            // ����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
	            URLConnection uc = url.openConnection();
	            // �򿪵����Ӷ�ȡ����������
	            InputStream in = uc.getInputStream();
	            StringBuilder sb = new StringBuilder();
	            String line;
	            BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
	            String str = sb.toString();
	            return str;  
	        } catch (Exception e) {
	            //return false;
	        	e.printStackTrace();
	        }
 		return null;
	}

}
