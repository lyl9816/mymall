package com.snack.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdUsernameIsNull() {
            addCriterion("ad_username is null");
            return (Criteria) this;
        }

        public Criteria andAdUsernameIsNotNull() {
            addCriterion("ad_username is not null");
            return (Criteria) this;
        }

        public Criteria andAdUsernameEqualTo(String value) {
            addCriterion("ad_username =", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameNotEqualTo(String value) {
            addCriterion("ad_username <>", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameGreaterThan(String value) {
            addCriterion("ad_username >", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_username >=", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameLessThan(String value) {
            addCriterion("ad_username <", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameLessThanOrEqualTo(String value) {
            addCriterion("ad_username <=", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameLike(String value) {
            addCriterion("ad_username like", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameNotLike(String value) {
            addCriterion("ad_username not like", value, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameIn(List<String> values) {
            addCriterion("ad_username in", values, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameNotIn(List<String> values) {
            addCriterion("ad_username not in", values, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameBetween(String value1, String value2) {
            addCriterion("ad_username between", value1, value2, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdUsernameNotBetween(String value1, String value2) {
            addCriterion("ad_username not between", value1, value2, "adUsername");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIsNull() {
            addCriterion("ad_password is null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIsNotNull() {
            addCriterion("ad_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordEqualTo(String value) {
            addCriterion("ad_password =", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotEqualTo(String value) {
            addCriterion("ad_password <>", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordGreaterThan(String value) {
            addCriterion("ad_password >", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ad_password >=", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLessThan(String value) {
            addCriterion("ad_password <", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLessThanOrEqualTo(String value) {
            addCriterion("ad_password <=", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLike(String value) {
            addCriterion("ad_password like", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotLike(String value) {
            addCriterion("ad_password not like", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIn(List<String> values) {
            addCriterion("ad_password in", values, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotIn(List<String> values) {
            addCriterion("ad_password not in", values, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordBetween(String value1, String value2) {
            addCriterion("ad_password between", value1, value2, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotBetween(String value1, String value2) {
            addCriterion("ad_password not between", value1, value2, "adPassword");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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