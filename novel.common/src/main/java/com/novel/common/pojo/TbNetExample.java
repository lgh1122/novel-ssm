package com.novel.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbNetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbNetExample() {
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

        public Criteria andNetnameIsNull() {
            addCriterion("netname is null");
            return (Criteria) this;
        }

        public Criteria andNetnameIsNotNull() {
            addCriterion("netname is not null");
            return (Criteria) this;
        }

        public Criteria andNetnameEqualTo(String value) {
            addCriterion("netname =", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotEqualTo(String value) {
            addCriterion("netname <>", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameGreaterThan(String value) {
            addCriterion("netname >", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameGreaterThanOrEqualTo(String value) {
            addCriterion("netname >=", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLessThan(String value) {
            addCriterion("netname <", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLessThanOrEqualTo(String value) {
            addCriterion("netname <=", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLike(String value) {
            addCriterion("netname like", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotLike(String value) {
            addCriterion("netname not like", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameIn(List<String> values) {
            addCriterion("netname in", values, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotIn(List<String> values) {
            addCriterion("netname not in", values, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameBetween(String value1, String value2) {
            addCriterion("netname between", value1, value2, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotBetween(String value1, String value2) {
            addCriterion("netname not between", value1, value2, "netname");
            return (Criteria) this;
        }

        public Criteria andBaseurlIsNull() {
            addCriterion("baseurl is null");
            return (Criteria) this;
        }

        public Criteria andBaseurlIsNotNull() {
            addCriterion("baseurl is not null");
            return (Criteria) this;
        }

        public Criteria andBaseurlEqualTo(String value) {
            addCriterion("baseurl =", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlNotEqualTo(String value) {
            addCriterion("baseurl <>", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlGreaterThan(String value) {
            addCriterion("baseurl >", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlGreaterThanOrEqualTo(String value) {
            addCriterion("baseurl >=", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlLessThan(String value) {
            addCriterion("baseurl <", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlLessThanOrEqualTo(String value) {
            addCriterion("baseurl <=", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlLike(String value) {
            addCriterion("baseurl like", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlNotLike(String value) {
            addCriterion("baseurl not like", value, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlIn(List<String> values) {
            addCriterion("baseurl in", values, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlNotIn(List<String> values) {
            addCriterion("baseurl not in", values, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlBetween(String value1, String value2) {
            addCriterion("baseurl between", value1, value2, "baseurl");
            return (Criteria) this;
        }

        public Criteria andBaseurlNotBetween(String value1, String value2) {
            addCriterion("baseurl not between", value1, value2, "baseurl");
            return (Criteria) this;
        }

        public Criteria andFullurlIsNull() {
            addCriterion("fullurl is null");
            return (Criteria) this;
        }

        public Criteria andFullurlIsNotNull() {
            addCriterion("fullurl is not null");
            return (Criteria) this;
        }

        public Criteria andFullurlEqualTo(String value) {
            addCriterion("fullurl =", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlNotEqualTo(String value) {
            addCriterion("fullurl <>", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlGreaterThan(String value) {
            addCriterion("fullurl >", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlGreaterThanOrEqualTo(String value) {
            addCriterion("fullurl >=", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlLessThan(String value) {
            addCriterion("fullurl <", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlLessThanOrEqualTo(String value) {
            addCriterion("fullurl <=", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlLike(String value) {
            addCriterion("fullurl like", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlNotLike(String value) {
            addCriterion("fullurl not like", value, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlIn(List<String> values) {
            addCriterion("fullurl in", values, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlNotIn(List<String> values) {
            addCriterion("fullurl not in", values, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlBetween(String value1, String value2) {
            addCriterion("fullurl between", value1, value2, "fullurl");
            return (Criteria) this;
        }

        public Criteria andFullurlNotBetween(String value1, String value2) {
            addCriterion("fullurl not between", value1, value2, "fullurl");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNull() {
            addCriterion("charset is null");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNotNull() {
            addCriterion("charset is not null");
            return (Criteria) this;
        }

        public Criteria andCharsetEqualTo(String value) {
            addCriterion("charset =", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotEqualTo(String value) {
            addCriterion("charset <>", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThan(String value) {
            addCriterion("charset >", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("charset >=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThan(String value) {
            addCriterion("charset <", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThanOrEqualTo(String value) {
            addCriterion("charset <=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLike(String value) {
            addCriterion("charset like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotLike(String value) {
            addCriterion("charset not like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetIn(List<String> values) {
            addCriterion("charset in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotIn(List<String> values) {
            addCriterion("charset not in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetBetween(String value1, String value2) {
            addCriterion("charset between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotBetween(String value1, String value2) {
            addCriterion("charset not between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andNovelurlIsNull() {
            addCriterion("novelurl is null");
            return (Criteria) this;
        }

        public Criteria andNovelurlIsNotNull() {
            addCriterion("novelurl is not null");
            return (Criteria) this;
        }

        public Criteria andNovelurlEqualTo(String value) {
            addCriterion("novelurl =", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlNotEqualTo(String value) {
            addCriterion("novelurl <>", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlGreaterThan(String value) {
            addCriterion("novelurl >", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlGreaterThanOrEqualTo(String value) {
            addCriterion("novelurl >=", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlLessThan(String value) {
            addCriterion("novelurl <", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlLessThanOrEqualTo(String value) {
            addCriterion("novelurl <=", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlLike(String value) {
            addCriterion("novelurl like", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlNotLike(String value) {
            addCriterion("novelurl not like", value, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlIn(List<String> values) {
            addCriterion("novelurl in", values, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlNotIn(List<String> values) {
            addCriterion("novelurl not in", values, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlBetween(String value1, String value2) {
            addCriterion("novelurl between", value1, value2, "novelurl");
            return (Criteria) this;
        }

        public Criteria andNovelurlNotBetween(String value1, String value2) {
            addCriterion("novelurl not between", value1, value2, "novelurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlIsNull() {
            addCriterion("chapterurl is null");
            return (Criteria) this;
        }

        public Criteria andChapterurlIsNotNull() {
            addCriterion("chapterurl is not null");
            return (Criteria) this;
        }

        public Criteria andChapterurlEqualTo(String value) {
            addCriterion("chapterurl =", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlNotEqualTo(String value) {
            addCriterion("chapterurl <>", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlGreaterThan(String value) {
            addCriterion("chapterurl >", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlGreaterThanOrEqualTo(String value) {
            addCriterion("chapterurl >=", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlLessThan(String value) {
            addCriterion("chapterurl <", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlLessThanOrEqualTo(String value) {
            addCriterion("chapterurl <=", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlLike(String value) {
            addCriterion("chapterurl like", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlNotLike(String value) {
            addCriterion("chapterurl not like", value, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlIn(List<String> values) {
            addCriterion("chapterurl in", values, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlNotIn(List<String> values) {
            addCriterion("chapterurl not in", values, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlBetween(String value1, String value2) {
            addCriterion("chapterurl between", value1, value2, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterurlNotBetween(String value1, String value2) {
            addCriterion("chapterurl not between", value1, value2, "chapterurl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlIsNull() {
            addCriterion("chapterinfourl is null");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlIsNotNull() {
            addCriterion("chapterinfourl is not null");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlEqualTo(String value) {
            addCriterion("chapterinfourl =", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlNotEqualTo(String value) {
            addCriterion("chapterinfourl <>", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlGreaterThan(String value) {
            addCriterion("chapterinfourl >", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlGreaterThanOrEqualTo(String value) {
            addCriterion("chapterinfourl >=", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlLessThan(String value) {
            addCriterion("chapterinfourl <", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlLessThanOrEqualTo(String value) {
            addCriterion("chapterinfourl <=", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlLike(String value) {
            addCriterion("chapterinfourl like", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlNotLike(String value) {
            addCriterion("chapterinfourl not like", value, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlIn(List<String> values) {
            addCriterion("chapterinfourl in", values, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlNotIn(List<String> values) {
            addCriterion("chapterinfourl not in", values, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlBetween(String value1, String value2) {
            addCriterion("chapterinfourl between", value1, value2, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andChapterinfourlNotBetween(String value1, String value2) {
            addCriterion("chapterinfourl not between", value1, value2, "chapterinfourl");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageurl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageurl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageurl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageurl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageurl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageurl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageurl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageurl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageurl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageurl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageurl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageurl not between", value1, value2, "imageurl");
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