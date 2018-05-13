package com.novel.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbNovelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbNovelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNetidIsNull() {
            addCriterion("netid is null");
            return (Criteria) this;
        }

        public Criteria andNetidIsNotNull() {
            addCriterion("netid is not null");
            return (Criteria) this;
        }

        public Criteria andNetidEqualTo(Long value) {
            addCriterion("netid =", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotEqualTo(Long value) {
            addCriterion("netid <>", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidGreaterThan(Long value) {
            addCriterion("netid >", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidGreaterThanOrEqualTo(Long value) {
            addCriterion("netid >=", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidLessThan(Long value) {
            addCriterion("netid <", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidLessThanOrEqualTo(Long value) {
            addCriterion("netid <=", value, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidIn(List<Long> values) {
            addCriterion("netid in", values, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotIn(List<Long> values) {
            addCriterion("netid not in", values, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidBetween(Long value1, Long value2) {
            addCriterion("netid between", value1, value2, "netid");
            return (Criteria) this;
        }

        public Criteria andNetidNotBetween(Long value1, Long value2) {
            addCriterion("netid not between", value1, value2, "netid");
            return (Criteria) this;
        }

        public Criteria andtitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andtitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andtitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andtitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andtitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andtitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameIsNull() {
            addCriterion("latestchaptername is null");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameIsNotNull() {
            addCriterion("latestchaptername is not null");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameEqualTo(String value) {
            addCriterion("latestchaptername =", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameNotEqualTo(String value) {
            addCriterion("latestchaptername <>", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameGreaterThan(String value) {
            addCriterion("latestchaptername >", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameGreaterThanOrEqualTo(String value) {
            addCriterion("latestchaptername >=", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameLessThan(String value) {
            addCriterion("latestchaptername <", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameLessThanOrEqualTo(String value) {
            addCriterion("latestchaptername <=", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameLike(String value) {
            addCriterion("latestchaptername like", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameNotLike(String value) {
            addCriterion("latestchaptername not like", value, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameIn(List<String> values) {
            addCriterion("latestchaptername in", values, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameNotIn(List<String> values) {
            addCriterion("latestchaptername not in", values, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameBetween(String value1, String value2) {
            addCriterion("latestchaptername between", value1, value2, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapternameNotBetween(String value1, String value2) {
            addCriterion("latestchaptername not between", value1, value2, "latestchaptername");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridIsNull() {
            addCriterion("latestchapterid is null");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridIsNotNull() {
            addCriterion("latestchapterid is not null");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridEqualTo(Long value) {
            addCriterion("latestchapterid =", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridNotEqualTo(Long value) {
            addCriterion("latestchapterid <>", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridGreaterThan(Long value) {
            addCriterion("latestchapterid >", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridGreaterThanOrEqualTo(Long value) {
            addCriterion("latestchapterid >=", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridLessThan(Long value) {
            addCriterion("latestchapterid <", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridLessThanOrEqualTo(Long value) {
            addCriterion("latestchapterid <=", value, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridIn(List<Long> values) {
            addCriterion("latestchapterid in", values, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridNotIn(List<Long> values) {
            addCriterion("latestchapterid not in", values, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridBetween(Long value1, Long value2) {
            addCriterion("latestchapterid between", value1, value2, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andLatestchapteridNotBetween(Long value1, Long value2) {
            addCriterion("latestchapterid not between", value1, value2, "latestchapterid");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andVaildIsNull() {
            addCriterion("vaild is null");
            return (Criteria) this;
        }

        public Criteria andVaildIsNotNull() {
            addCriterion("vaild is not null");
            return (Criteria) this;
        }

        public Criteria andVaildEqualTo(Byte value) {
            addCriterion("vaild =", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildNotEqualTo(Byte value) {
            addCriterion("vaild <>", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildGreaterThan(Byte value) {
            addCriterion("vaild >", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildGreaterThanOrEqualTo(Byte value) {
            addCriterion("vaild >=", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildLessThan(Byte value) {
            addCriterion("vaild <", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildLessThanOrEqualTo(Byte value) {
            addCriterion("vaild <=", value, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildIn(List<Byte> values) {
            addCriterion("vaild in", values, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildNotIn(List<Byte> values) {
            addCriterion("vaild not in", values, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildBetween(Byte value1, Byte value2) {
            addCriterion("vaild between", value1, value2, "vaild");
            return (Criteria) this;
        }

        public Criteria andVaildNotBetween(Byte value1, Byte value2) {
            addCriterion("vaild not between", value1, value2, "vaild");
            return (Criteria) this;
        }

        public Criteria andIshaschapterIsNull() {
            addCriterion("ishaschapter is null");
            return (Criteria) this;
        }

        public Criteria andIshaschapterIsNotNull() {
            addCriterion("ishaschapter is not null");
            return (Criteria) this;
        }

        public Criteria andIshaschapterEqualTo(Byte value) {
            addCriterion("ishaschapter =", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterNotEqualTo(Byte value) {
            addCriterion("ishaschapter <>", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterGreaterThan(Byte value) {
            addCriterion("ishaschapter >", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterGreaterThanOrEqualTo(Byte value) {
            addCriterion("ishaschapter >=", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterLessThan(Byte value) {
            addCriterion("ishaschapter <", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterLessThanOrEqualTo(Byte value) {
            addCriterion("ishaschapter <=", value, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterIn(List<Byte> values) {
            addCriterion("ishaschapter in", values, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterNotIn(List<Byte> values) {
            addCriterion("ishaschapter not in", values, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterBetween(Byte value1, Byte value2) {
            addCriterion("ishaschapter between", value1, value2, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andIshaschapterNotBetween(Byte value1, Byte value2) {
            addCriterion("ishaschapter not between", value1, value2, "ishaschapter");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNull() {
            addCriterion("clicknum is null");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNotNull() {
            addCriterion("clicknum is not null");
            return (Criteria) this;
        }

        public Criteria andClicknumEqualTo(Integer value) {
            addCriterion("clicknum =", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotEqualTo(Integer value) {
            addCriterion("clicknum <>", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThan(Integer value) {
            addCriterion("clicknum >", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicknum >=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThan(Integer value) {
            addCriterion("clicknum <", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThanOrEqualTo(Integer value) {
            addCriterion("clicknum <=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumIn(List<Integer> values) {
            addCriterion("clicknum in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotIn(List<Integer> values) {
            addCriterion("clicknum not in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumBetween(Integer value1, Integer value2) {
            addCriterion("clicknum between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotBetween(Integer value1, Integer value2) {
            addCriterion("clicknum not between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andDownnumIsNull() {
            addCriterion("downnum is null");
            return (Criteria) this;
        }

        public Criteria andDownnumIsNotNull() {
            addCriterion("downnum is not null");
            return (Criteria) this;
        }

        public Criteria andDownnumEqualTo(Integer value) {
            addCriterion("downnum =", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumNotEqualTo(Integer value) {
            addCriterion("downnum <>", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumGreaterThan(Integer value) {
            addCriterion("downnum >", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("downnum >=", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumLessThan(Integer value) {
            addCriterion("downnum <", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumLessThanOrEqualTo(Integer value) {
            addCriterion("downnum <=", value, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumIn(List<Integer> values) {
            addCriterion("downnum in", values, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumNotIn(List<Integer> values) {
            addCriterion("downnum not in", values, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumBetween(Integer value1, Integer value2) {
            addCriterion("downnum between", value1, value2, "downnum");
            return (Criteria) this;
        }

        public Criteria andDownnumNotBetween(Integer value1, Integer value2) {
            addCriterion("downnum not between", value1, value2, "downnum");
            return (Criteria) this;
        }

        public Criteria andChapteroldidIsNull() {
            addCriterion("chapteroldid is null");
            return (Criteria) this;
        }

        public Criteria andChapteroldidIsNotNull() {
            addCriterion("chapteroldid is not null");
            return (Criteria) this;
        }

        public Criteria andChapteroldidEqualTo(Long value) {
            addCriterion("chapteroldid =", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidNotEqualTo(Long value) {
            addCriterion("chapteroldid <>", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidGreaterThan(Long value) {
            addCriterion("chapteroldid >", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidGreaterThanOrEqualTo(Long value) {
            addCriterion("chapteroldid >=", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidLessThan(Long value) {
            addCriterion("chapteroldid <", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidLessThanOrEqualTo(Long value) {
            addCriterion("chapteroldid <=", value, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidIn(List<Long> values) {
            addCriterion("chapteroldid in", values, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidNotIn(List<Long> values) {
            addCriterion("chapteroldid not in", values, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidBetween(Long value1, Long value2) {
            addCriterion("chapteroldid between", value1, value2, "chapteroldid");
            return (Criteria) this;
        }

        public Criteria andChapteroldidNotBetween(Long value1, Long value2) {
            addCriterion("chapteroldid not between", value1, value2, "chapteroldid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}