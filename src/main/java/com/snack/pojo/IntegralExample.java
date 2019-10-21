package com.snack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IntegralExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIIdIsNull() {
            addCriterion("i_id is null");
            return (Criteria) this;
        }

        public Criteria andIIdIsNotNull() {
            addCriterion("i_id is not null");
            return (Criteria) this;
        }

        public Criteria andIIdEqualTo(Integer value) {
            addCriterion("i_id =", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotEqualTo(Integer value) {
            addCriterion("i_id <>", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThan(Integer value) {
            addCriterion("i_id >", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_id >=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThan(Integer value) {
            addCriterion("i_id <", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThanOrEqualTo(Integer value) {
            addCriterion("i_id <=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdIn(List<Integer> values) {
            addCriterion("i_id in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotIn(List<Integer> values) {
            addCriterion("i_id not in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdBetween(Integer value1, Integer value2) {
            addCriterion("i_id between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("i_id not between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andINumberIsNull() {
            addCriterion("i_number is null");
            return (Criteria) this;
        }

        public Criteria andINumberIsNotNull() {
            addCriterion("i_number is not null");
            return (Criteria) this;
        }

        public Criteria andINumberEqualTo(Integer value) {
            addCriterion("i_number =", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberNotEqualTo(Integer value) {
            addCriterion("i_number <>", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberGreaterThan(Integer value) {
            addCriterion("i_number >", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_number >=", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberLessThan(Integer value) {
            addCriterion("i_number <", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberLessThanOrEqualTo(Integer value) {
            addCriterion("i_number <=", value, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberIn(List<Integer> values) {
            addCriterion("i_number in", values, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberNotIn(List<Integer> values) {
            addCriterion("i_number not in", values, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberBetween(Integer value1, Integer value2) {
            addCriterion("i_number between", value1, value2, "iNumber");
            return (Criteria) this;
        }

        public Criteria andINumberNotBetween(Integer value1, Integer value2) {
            addCriterion("i_number not between", value1, value2, "iNumber");
            return (Criteria) this;
        }

        public Criteria andITimeIsNull() {
            addCriterion("i_time is null");
            return (Criteria) this;
        }

        public Criteria andITimeIsNotNull() {
            addCriterion("i_time is not null");
            return (Criteria) this;
        }

        public Criteria andITimeEqualTo(Date value) {
            addCriterionForJDBCDate("i_time =", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("i_time <>", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThan(Date value) {
            addCriterionForJDBCDate("i_time >", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("i_time >=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThan(Date value) {
            addCriterionForJDBCDate("i_time <", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("i_time <=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeIn(List<Date> values) {
            addCriterionForJDBCDate("i_time in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("i_time not in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("i_time between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("i_time not between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andIDeseIsNull() {
            addCriterion("i_dese is null");
            return (Criteria) this;
        }

        public Criteria andIDeseIsNotNull() {
            addCriterion("i_dese is not null");
            return (Criteria) this;
        }

        public Criteria andIDeseEqualTo(String value) {
            addCriterion("i_dese =", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseNotEqualTo(String value) {
            addCriterion("i_dese <>", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseGreaterThan(String value) {
            addCriterion("i_dese >", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseGreaterThanOrEqualTo(String value) {
            addCriterion("i_dese >=", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseLessThan(String value) {
            addCriterion("i_dese <", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseLessThanOrEqualTo(String value) {
            addCriterion("i_dese <=", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseLike(String value) {
            addCriterion("i_dese like", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseNotLike(String value) {
            addCriterion("i_dese not like", value, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseIn(List<String> values) {
            addCriterion("i_dese in", values, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseNotIn(List<String> values) {
            addCriterion("i_dese not in", values, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseBetween(String value1, String value2) {
            addCriterion("i_dese between", value1, value2, "iDese");
            return (Criteria) this;
        }

        public Criteria andIDeseNotBetween(String value1, String value2) {
            addCriterion("i_dese not between", value1, value2, "iDese");
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