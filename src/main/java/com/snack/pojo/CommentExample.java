package com.snack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEParentidIsNull() {
            addCriterion("e_parentId is null");
            return (Criteria) this;
        }

        public Criteria andEParentidIsNotNull() {
            addCriterion("e_parentId is not null");
            return (Criteria) this;
        }

        public Criteria andEParentidEqualTo(Integer value) {
            addCriterion("e_parentId =", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidNotEqualTo(Integer value) {
            addCriterion("e_parentId <>", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidGreaterThan(Integer value) {
            addCriterion("e_parentId >", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_parentId >=", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidLessThan(Integer value) {
            addCriterion("e_parentId <", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidLessThanOrEqualTo(Integer value) {
            addCriterion("e_parentId <=", value, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidIn(List<Integer> values) {
            addCriterion("e_parentId in", values, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidNotIn(List<Integer> values) {
            addCriterion("e_parentId not in", values, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidBetween(Integer value1, Integer value2) {
            addCriterion("e_parentId between", value1, value2, "eParentid");
            return (Criteria) this;
        }

        public Criteria andEParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("e_parentId not between", value1, value2, "eParentid");
            return (Criteria) this;
        }

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
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

        public Criteria andEPicturenameIsNull() {
            addCriterion("e_pictureName is null");
            return (Criteria) this;
        }

        public Criteria andEPicturenameIsNotNull() {
            addCriterion("e_pictureName is not null");
            return (Criteria) this;
        }

        public Criteria andEPicturenameEqualTo(String value) {
            addCriterion("e_pictureName =", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameNotEqualTo(String value) {
            addCriterion("e_pictureName <>", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameGreaterThan(String value) {
            addCriterion("e_pictureName >", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameGreaterThanOrEqualTo(String value) {
            addCriterion("e_pictureName >=", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameLessThan(String value) {
            addCriterion("e_pictureName <", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameLessThanOrEqualTo(String value) {
            addCriterion("e_pictureName <=", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameLike(String value) {
            addCriterion("e_pictureName like", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameNotLike(String value) {
            addCriterion("e_pictureName not like", value, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameIn(List<String> values) {
            addCriterion("e_pictureName in", values, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameNotIn(List<String> values) {
            addCriterion("e_pictureName not in", values, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameBetween(String value1, String value2) {
            addCriterion("e_pictureName between", value1, value2, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andEPicturenameNotBetween(String value1, String value2) {
            addCriterion("e_pictureName not between", value1, value2, "ePicturename");
            return (Criteria) this;
        }

        public Criteria andETypeIsNull() {
            addCriterion("e_type is null");
            return (Criteria) this;
        }

        public Criteria andETypeIsNotNull() {
            addCriterion("e_type is not null");
            return (Criteria) this;
        }

        public Criteria andETypeEqualTo(Integer value) {
            addCriterion("e_type =", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotEqualTo(Integer value) {
            addCriterion("e_type <>", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeGreaterThan(Integer value) {
            addCriterion("e_type >", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_type >=", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeLessThan(Integer value) {
            addCriterion("e_type <", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeLessThanOrEqualTo(Integer value) {
            addCriterion("e_type <=", value, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeIn(List<Integer> values) {
            addCriterion("e_type in", values, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotIn(List<Integer> values) {
            addCriterion("e_type not in", values, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeBetween(Integer value1, Integer value2) {
            addCriterion("e_type between", value1, value2, "eType");
            return (Criteria) this;
        }

        public Criteria andETypeNotBetween(Integer value1, Integer value2) {
            addCriterion("e_type not between", value1, value2, "eType");
            return (Criteria) this;
        }

        public Criteria andEScoreIsNull() {
            addCriterion("e_score is null");
            return (Criteria) this;
        }

        public Criteria andEScoreIsNotNull() {
            addCriterion("e_score is not null");
            return (Criteria) this;
        }

        public Criteria andEScoreEqualTo(Integer value) {
            addCriterion("e_score =", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreNotEqualTo(Integer value) {
            addCriterion("e_score <>", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreGreaterThan(Integer value) {
            addCriterion("e_score >", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_score >=", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreLessThan(Integer value) {
            addCriterion("e_score <", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreLessThanOrEqualTo(Integer value) {
            addCriterion("e_score <=", value, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreIn(List<Integer> values) {
            addCriterion("e_score in", values, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreNotIn(List<Integer> values) {
            addCriterion("e_score not in", values, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreBetween(Integer value1, Integer value2) {
            addCriterion("e_score between", value1, value2, "eScore");
            return (Criteria) this;
        }

        public Criteria andEScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("e_score not between", value1, value2, "eScore");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andEDateIsNull() {
            addCriterion("e_date is null");
            return (Criteria) this;
        }

        public Criteria andEDateIsNotNull() {
            addCriterion("e_date is not null");
            return (Criteria) this;
        }

        public Criteria andEDateEqualTo(Date value) {
            addCriterionForJDBCDate("e_date =", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("e_date <>", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateGreaterThan(Date value) {
            addCriterionForJDBCDate("e_date >", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e_date >=", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateLessThan(Date value) {
            addCriterionForJDBCDate("e_date <", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e_date <=", value, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateIn(List<Date> values) {
            addCriterionForJDBCDate("e_date in", values, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("e_date not in", values, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e_date between", value1, value2, "eDate");
            return (Criteria) this;
        }

        public Criteria andEDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e_date not between", value1, value2, "eDate");
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