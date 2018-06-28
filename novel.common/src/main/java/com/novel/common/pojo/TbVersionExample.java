package com.novel.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbVersionExample() {
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

        public Criteria andAppnameIsNull() {
            addCriterion("appName is null");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNotNull() {
            addCriterion("appName is not null");
            return (Criteria) this;
        }

        public Criteria andAppnameEqualTo(String value) {
            addCriterion("appName =", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotEqualTo(String value) {
            addCriterion("appName <>", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThan(String value) {
            addCriterion("appName >", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThanOrEqualTo(String value) {
            addCriterion("appName >=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThan(String value) {
            addCriterion("appName <", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThanOrEqualTo(String value) {
            addCriterion("appName <=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLike(String value) {
            addCriterion("appName like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotLike(String value) {
            addCriterion("appName not like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameIn(List<String> values) {
            addCriterion("appName in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotIn(List<String> values) {
            addCriterion("appName not in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameBetween(String value1, String value2) {
            addCriterion("appName between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotBetween(String value1, String value2) {
            addCriterion("appName not between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeIsNull() {
            addCriterion("newAppSize is null");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeIsNotNull() {
            addCriterion("newAppSize is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeEqualTo(Float value) {
            addCriterion("newAppSize =", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeNotEqualTo(Float value) {
            addCriterion("newAppSize <>", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeGreaterThan(Float value) {
            addCriterion("newAppSize >", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeGreaterThanOrEqualTo(Float value) {
            addCriterion("newAppSize >=", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeLessThan(Float value) {
            addCriterion("newAppSize <", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeLessThanOrEqualTo(Float value) {
            addCriterion("newAppSize <=", value, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeIn(List<Float> values) {
            addCriterion("newAppSize in", values, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeNotIn(List<Float> values) {
            addCriterion("newAppSize not in", values, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeBetween(Float value1, Float value2) {
            addCriterion("newAppSize between", value1, value2, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppSizeNotBetween(Float value1, Float value2) {
            addCriterion("newAppSize not between", value1, value2, "newAppSize");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeIsNull() {
            addCriterion("newAppVersionCode is null");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeIsNotNull() {
            addCriterion("newAppVersionCode is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeEqualTo(Integer value) {
            addCriterion("newAppVersionCode =", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeNotEqualTo(Integer value) {
            addCriterion("newAppVersionCode <>", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeGreaterThan(Integer value) {
            addCriterion("newAppVersionCode >", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("newAppVersionCode >=", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeLessThan(Integer value) {
            addCriterion("newAppVersionCode <", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("newAppVersionCode <=", value, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeIn(List<Integer> values) {
            addCriterion("newAppVersionCode in", values, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeNotIn(List<Integer> values) {
            addCriterion("newAppVersionCode not in", values, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("newAppVersionCode between", value1, value2, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("newAppVersionCode not between", value1, value2, "newAppVersionCode");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameIsNull() {
            addCriterion("newAppVersionName is null");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameIsNotNull() {
            addCriterion("newAppVersionName is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameEqualTo(String value) {
            addCriterion("newAppVersionName =", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameNotEqualTo(String value) {
            addCriterion("newAppVersionName <>", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameGreaterThan(String value) {
            addCriterion("newAppVersionName >", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameGreaterThanOrEqualTo(String value) {
            addCriterion("newAppVersionName >=", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameLessThan(String value) {
            addCriterion("newAppVersionName <", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameLessThanOrEqualTo(String value) {
            addCriterion("newAppVersionName <=", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameLike(String value) {
            addCriterion("newAppVersionName like", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameNotLike(String value) {
            addCriterion("newAppVersionName not like", value, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameIn(List<String> values) {
            addCriterion("newAppVersionName in", values, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameNotIn(List<String> values) {
            addCriterion("newAppVersionName not in", values, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameBetween(String value1, String value2) {
            addCriterion("newAppVersionName between", value1, value2, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppVersionNameNotBetween(String value1, String value2) {
            addCriterion("newAppVersionName not between", value1, value2, "newAppVersionName");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescIsNull() {
            addCriterion("newAppUpdateDesc is null");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescIsNotNull() {
            addCriterion("newAppUpdateDesc is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescEqualTo(String value) {
            addCriterion("newAppUpdateDesc =", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescNotEqualTo(String value) {
            addCriterion("newAppUpdateDesc <>", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescGreaterThan(String value) {
            addCriterion("newAppUpdateDesc >", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescGreaterThanOrEqualTo(String value) {
            addCriterion("newAppUpdateDesc >=", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescLessThan(String value) {
            addCriterion("newAppUpdateDesc <", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescLessThanOrEqualTo(String value) {
            addCriterion("newAppUpdateDesc <=", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescLike(String value) {
            addCriterion("newAppUpdateDesc like", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescNotLike(String value) {
            addCriterion("newAppUpdateDesc not like", value, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescIn(List<String> values) {
            addCriterion("newAppUpdateDesc in", values, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescNotIn(List<String> values) {
            addCriterion("newAppUpdateDesc not in", values, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescBetween(String value1, String value2) {
            addCriterion("newAppUpdateDesc between", value1, value2, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppUpdateDescNotBetween(String value1, String value2) {
            addCriterion("newAppUpdateDesc not between", value1, value2, "newAppUpdateDesc");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeIsNull() {
            addCriterion("newAppReleaseTime is null");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeIsNotNull() {
            addCriterion("newAppReleaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeEqualTo(String value) {
            addCriterion("newAppReleaseTime =", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeNotEqualTo(String value) {
            addCriterion("newAppReleaseTime <>", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeGreaterThan(String value) {
            addCriterion("newAppReleaseTime >", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("newAppReleaseTime >=", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeLessThan(String value) {
            addCriterion("newAppReleaseTime <", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeLessThanOrEqualTo(String value) {
            addCriterion("newAppReleaseTime <=", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeLike(String value) {
            addCriterion("newAppReleaseTime like", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeNotLike(String value) {
            addCriterion("newAppReleaseTime not like", value, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeIn(List<String> values) {
            addCriterion("newAppReleaseTime in", values, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeNotIn(List<String> values) {
            addCriterion("newAppReleaseTime not in", values, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeBetween(String value1, String value2) {
            addCriterion("newAppReleaseTime between", value1, value2, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppReleaseTimeNotBetween(String value1, String value2) {
            addCriterion("newAppReleaseTime not between", value1, value2, "newAppReleaseTime");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlIsNull() {
            addCriterion("newAppUrl is null");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlIsNotNull() {
            addCriterion("newAppUrl is not null");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlEqualTo(String value) {
            addCriterion("newAppUrl =", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlNotEqualTo(String value) {
            addCriterion("newAppUrl <>", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlGreaterThan(String value) {
            addCriterion("newAppUrl >", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlGreaterThanOrEqualTo(String value) {
            addCriterion("newAppUrl >=", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlLessThan(String value) {
            addCriterion("newAppUrl <", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlLessThanOrEqualTo(String value) {
            addCriterion("newAppUrl <=", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlLike(String value) {
            addCriterion("newAppUrl like", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlNotLike(String value) {
            addCriterion("newAppUrl not like", value, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlIn(List<String> values) {
            addCriterion("newAppUrl in", values, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlNotIn(List<String> values) {
            addCriterion("newAppUrl not in", values, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlBetween(String value1, String value2) {
            addCriterion("newAppUrl between", value1, value2, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andnewAppUrlNotBetween(String value1, String value2) {
            addCriterion("newAppUrl not between", value1, value2, "newAppUrl");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateIsNull() {
            addCriterion("isForceUpdate is null");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateIsNotNull() {
            addCriterion("isForceUpdate is not null");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateEqualTo(Integer value) {
            addCriterion("isForceUpdate =", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateNotEqualTo(Integer value) {
            addCriterion("isForceUpdate <>", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateGreaterThan(Integer value) {
            addCriterion("isForceUpdate >", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("isForceUpdate >=", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateLessThan(Integer value) {
            addCriterion("isForceUpdate <", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("isForceUpdate <=", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateIn(List<Integer> values) {
            addCriterion("isForceUpdate in", values, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateNotIn(List<Integer> values) {
            addCriterion("isForceUpdate not in", values, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateBetween(Integer value1, Integer value2) {
            addCriterion("isForceUpdate between", value1, value2, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisForceUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("isForceUpdate not between", value1, value2, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageIsNull() {
            addCriterion("isUseNewPage is null");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageIsNotNull() {
            addCriterion("isUseNewPage is not null");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageEqualTo(Integer value) {
            addCriterion("isUseNewPage =", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageNotEqualTo(Integer value) {
            addCriterion("isUseNewPage <>", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageGreaterThan(Integer value) {
            addCriterion("isUseNewPage >", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageGreaterThanOrEqualTo(Integer value) {
            addCriterion("isUseNewPage >=", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageLessThan(Integer value) {
            addCriterion("isUseNewPage <", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageLessThanOrEqualTo(Integer value) {
            addCriterion("isUseNewPage <=", value, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageIn(List<Integer> values) {
            addCriterion("isUseNewPage in", values, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageNotIn(List<Integer> values) {
            addCriterion("isUseNewPage not in", values, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageBetween(Integer value1, Integer value2) {
            addCriterion("isUseNewPage between", value1, value2, "isUseNewPage");
            return (Criteria) this;
        }

        public Criteria andisUseNewPageNotBetween(Integer value1, Integer value2) {
            addCriterion("isUseNewPage not between", value1, value2, "isUseNewPage");
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