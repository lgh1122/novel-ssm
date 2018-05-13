package com.novel.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbChapterExample() {
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

        public Criteria andNovelIdIsNull() {
            addCriterion("novelId is null");
            return (Criteria) this;
        }

        public Criteria andNovelIdIsNotNull() {
            addCriterion("novelId is not null");
            return (Criteria) this;
        }

        public Criteria andNovelIdEqualTo(Long value) {
            addCriterion("novelId =", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotEqualTo(Long value) {
            addCriterion("novelId <>", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdGreaterThan(Long value) {
            addCriterion("novelId >", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("novelId >=", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdLessThan(Long value) {
            addCriterion("novelId <", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdLessThanOrEqualTo(Long value) {
            addCriterion("novelId <=", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdIn(List<Long> values) {
            addCriterion("novelId in", values, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotIn(List<Long> values) {
            addCriterion("novelId not in", values, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdBetween(Long value1, Long value2) {
            addCriterion("novelId between", value1, value2, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotBetween(Long value1, Long value2) {
            addCriterion("novelId not between", value1, value2, "novelId");
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

        public Criteria andchapterPathIsNull() {
            addCriterion("chapterPath is null");
            return (Criteria) this;
        }

        public Criteria andchapterPathIsNotNull() {
            addCriterion("chapterPath is not null");
            return (Criteria) this;
        }

        public Criteria andchapterPathEqualTo(String value) {
            addCriterion("chapterPath =", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathNotEqualTo(String value) {
            addCriterion("chapterPath <>", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathGreaterThan(String value) {
            addCriterion("chapterPath >", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathGreaterThanOrEqualTo(String value) {
            addCriterion("chapterPath >=", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathLessThan(String value) {
            addCriterion("chapterPath <", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathLessThanOrEqualTo(String value) {
            addCriterion("chapterPath <=", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathLike(String value) {
            addCriterion("chapterPath like", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathNotLike(String value) {
            addCriterion("chapterPath not like", value, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathIn(List<String> values) {
            addCriterion("chapterPath in", values, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathNotIn(List<String> values) {
            addCriterion("chapterPath not in", values, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathBetween(String value1, String value2) {
            addCriterion("chapterPath between", value1, value2, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andchapterPathNotBetween(String value1, String value2) {
            addCriterion("chapterPath not between", value1, value2, "chapterPath");
            return (Criteria) this;
        }

        public Criteria andPrevIdIsNull() {
            addCriterion("prevId is null");
            return (Criteria) this;
        }

        public Criteria andPrevIdIsNotNull() {
            addCriterion("prevId is not null");
            return (Criteria) this;
        }

        public Criteria andPrevIdEqualTo(Long value) {
            addCriterion("prevId =", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdNotEqualTo(Long value) {
            addCriterion("prevId <>", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdGreaterThan(Long value) {
            addCriterion("prevId >", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prevId >=", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdLessThan(Long value) {
            addCriterion("prevId <", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdLessThanOrEqualTo(Long value) {
            addCriterion("prevId <=", value, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdIn(List<Long> values) {
            addCriterion("prevId in", values, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdNotIn(List<Long> values) {
            addCriterion("prevId not in", values, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdBetween(Long value1, Long value2) {
            addCriterion("prevId between", value1, value2, "prevId");
            return (Criteria) this;
        }

        public Criteria andPrevIdNotBetween(Long value1, Long value2) {
            addCriterion("prevId not between", value1, value2, "prevId");
            return (Criteria) this;
        }

        public Criteria andNextIdIsNull() {
            addCriterion("nextId is null");
            return (Criteria) this;
        }

        public Criteria andNextIdIsNotNull() {
            addCriterion("nextId is not null");
            return (Criteria) this;
        }

        public Criteria andNextIdEqualTo(Long value) {
            addCriterion("nextId =", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotEqualTo(Long value) {
            addCriterion("nextId <>", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdGreaterThan(Long value) {
            addCriterion("nextId >", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nextId >=", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdLessThan(Long value) {
            addCriterion("nextId <", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdLessThanOrEqualTo(Long value) {
            addCriterion("nextId <=", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdIn(List<Long> values) {
            addCriterion("nextId in", values, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotIn(List<Long> values) {
            addCriterion("nextId not in", values, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdBetween(Long value1, Long value2) {
            addCriterion("nextId between", value1, value2, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotBetween(Long value1, Long value2) {
            addCriterion("nextId not between", value1, value2, "nextId");
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