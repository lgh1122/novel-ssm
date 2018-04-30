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

        public Criteria andNovelidIsNull() {
            addCriterion("novelid is null");
            return (Criteria) this;
        }

        public Criteria andNovelidIsNotNull() {
            addCriterion("novelid is not null");
            return (Criteria) this;
        }

        public Criteria andNovelidEqualTo(Long value) {
            addCriterion("novelid =", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotEqualTo(Long value) {
            addCriterion("novelid <>", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidGreaterThan(Long value) {
            addCriterion("novelid >", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidGreaterThanOrEqualTo(Long value) {
            addCriterion("novelid >=", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidLessThan(Long value) {
            addCriterion("novelid <", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidLessThanOrEqualTo(Long value) {
            addCriterion("novelid <=", value, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidIn(List<Long> values) {
            addCriterion("novelid in", values, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotIn(List<Long> values) {
            addCriterion("novelid not in", values, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidBetween(Long value1, Long value2) {
            addCriterion("novelid between", value1, value2, "novelid");
            return (Criteria) this;
        }

        public Criteria andNovelidNotBetween(Long value1, Long value2) {
            addCriterion("novelid not between", value1, value2, "novelid");
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

        public Criteria andTittleIsNull() {
            addCriterion("tittle is null");
            return (Criteria) this;
        }

        public Criteria andTittleIsNotNull() {
            addCriterion("tittle is not null");
            return (Criteria) this;
        }

        public Criteria andTittleEqualTo(String value) {
            addCriterion("tittle =", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotEqualTo(String value) {
            addCriterion("tittle <>", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleGreaterThan(String value) {
            addCriterion("tittle >", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleGreaterThanOrEqualTo(String value) {
            addCriterion("tittle >=", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLessThan(String value) {
            addCriterion("tittle <", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLessThanOrEqualTo(String value) {
            addCriterion("tittle <=", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLike(String value) {
            addCriterion("tittle like", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotLike(String value) {
            addCriterion("tittle not like", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleIn(List<String> values) {
            addCriterion("tittle in", values, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotIn(List<String> values) {
            addCriterion("tittle not in", values, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleBetween(String value1, String value2) {
            addCriterion("tittle between", value1, value2, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotBetween(String value1, String value2) {
            addCriterion("tittle not between", value1, value2, "tittle");
            return (Criteria) this;
        }

        public Criteria andChapterpathIsNull() {
            addCriterion("chapterpath is null");
            return (Criteria) this;
        }

        public Criteria andChapterpathIsNotNull() {
            addCriterion("chapterpath is not null");
            return (Criteria) this;
        }

        public Criteria andChapterpathEqualTo(String value) {
            addCriterion("chapterpath =", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathNotEqualTo(String value) {
            addCriterion("chapterpath <>", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathGreaterThan(String value) {
            addCriterion("chapterpath >", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathGreaterThanOrEqualTo(String value) {
            addCriterion("chapterpath >=", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathLessThan(String value) {
            addCriterion("chapterpath <", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathLessThanOrEqualTo(String value) {
            addCriterion("chapterpath <=", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathLike(String value) {
            addCriterion("chapterpath like", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathNotLike(String value) {
            addCriterion("chapterpath not like", value, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathIn(List<String> values) {
            addCriterion("chapterpath in", values, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathNotIn(List<String> values) {
            addCriterion("chapterpath not in", values, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathBetween(String value1, String value2) {
            addCriterion("chapterpath between", value1, value2, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andChapterpathNotBetween(String value1, String value2) {
            addCriterion("chapterpath not between", value1, value2, "chapterpath");
            return (Criteria) this;
        }

        public Criteria andPrevidIsNull() {
            addCriterion("previd is null");
            return (Criteria) this;
        }

        public Criteria andPrevidIsNotNull() {
            addCriterion("previd is not null");
            return (Criteria) this;
        }

        public Criteria andPrevidEqualTo(Long value) {
            addCriterion("previd =", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidNotEqualTo(Long value) {
            addCriterion("previd <>", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidGreaterThan(Long value) {
            addCriterion("previd >", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidGreaterThanOrEqualTo(Long value) {
            addCriterion("previd >=", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidLessThan(Long value) {
            addCriterion("previd <", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidLessThanOrEqualTo(Long value) {
            addCriterion("previd <=", value, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidIn(List<Long> values) {
            addCriterion("previd in", values, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidNotIn(List<Long> values) {
            addCriterion("previd not in", values, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidBetween(Long value1, Long value2) {
            addCriterion("previd between", value1, value2, "previd");
            return (Criteria) this;
        }

        public Criteria andPrevidNotBetween(Long value1, Long value2) {
            addCriterion("previd not between", value1, value2, "previd");
            return (Criteria) this;
        }

        public Criteria andNextidIsNull() {
            addCriterion("nextid is null");
            return (Criteria) this;
        }

        public Criteria andNextidIsNotNull() {
            addCriterion("nextid is not null");
            return (Criteria) this;
        }

        public Criteria andNextidEqualTo(Long value) {
            addCriterion("nextid =", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotEqualTo(Long value) {
            addCriterion("nextid <>", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidGreaterThan(Long value) {
            addCriterion("nextid >", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidGreaterThanOrEqualTo(Long value) {
            addCriterion("nextid >=", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidLessThan(Long value) {
            addCriterion("nextid <", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidLessThanOrEqualTo(Long value) {
            addCriterion("nextid <=", value, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidIn(List<Long> values) {
            addCriterion("nextid in", values, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotIn(List<Long> values) {
            addCriterion("nextid not in", values, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidBetween(Long value1, Long value2) {
            addCriterion("nextid between", value1, value2, "nextid");
            return (Criteria) this;
        }

        public Criteria andNextidNotBetween(Long value1, Long value2) {
            addCriterion("nextid not between", value1, value2, "nextid");
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