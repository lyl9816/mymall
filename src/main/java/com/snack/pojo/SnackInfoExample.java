package com.snack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SnackInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SnackInfoExample() {
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

        public Criteria andSBatchIsNull() {
            addCriterion("s_batch is null");
            return (Criteria) this;
        }

        public Criteria andSBatchIsNotNull() {
            addCriterion("s_batch is not null");
            return (Criteria) this;
        }

        public Criteria andSBatchEqualTo(String value) {
            addCriterion("s_batch =", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchNotEqualTo(String value) {
            addCriterion("s_batch <>", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchGreaterThan(String value) {
            addCriterion("s_batch >", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchGreaterThanOrEqualTo(String value) {
            addCriterion("s_batch >=", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchLessThan(String value) {
            addCriterion("s_batch <", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchLessThanOrEqualTo(String value) {
            addCriterion("s_batch <=", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchLike(String value) {
            addCriterion("s_batch like", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchNotLike(String value) {
            addCriterion("s_batch not like", value, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchIn(List<String> values) {
            addCriterion("s_batch in", values, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchNotIn(List<String> values) {
            addCriterion("s_batch not in", values, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchBetween(String value1, String value2) {
            addCriterion("s_batch between", value1, value2, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSBatchNotBetween(String value1, String value2) {
            addCriterion("s_batch not between", value1, value2, "sBatch");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSPriceIsNull() {
            addCriterion("s_price is null");
            return (Criteria) this;
        }

        public Criteria andSPriceIsNotNull() {
            addCriterion("s_price is not null");
            return (Criteria) this;
        }

        public Criteria andSPriceEqualTo(Double value) {
            addCriterion("s_price =", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotEqualTo(Double value) {
            addCriterion("s_price <>", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceGreaterThan(Double value) {
            addCriterion("s_price >", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("s_price >=", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceLessThan(Double value) {
            addCriterion("s_price <", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceLessThanOrEqualTo(Double value) {
            addCriterion("s_price <=", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceIn(List<Double> values) {
            addCriterion("s_price in", values, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotIn(List<Double> values) {
            addCriterion("s_price not in", values, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceBetween(Double value1, Double value2) {
            addCriterion("s_price between", value1, value2, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotBetween(Double value1, Double value2) {
            addCriterion("s_price not between", value1, value2, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSDiscountIsNull() {
            addCriterion("s_discount is null");
            return (Criteria) this;
        }

        public Criteria andSDiscountIsNotNull() {
            addCriterion("s_discount is not null");
            return (Criteria) this;
        }

        public Criteria andSDiscountEqualTo(String value) {
            addCriterion("s_discount =", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountNotEqualTo(String value) {
            addCriterion("s_discount <>", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountGreaterThan(String value) {
            addCriterion("s_discount >", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("s_discount >=", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountLessThan(String value) {
            addCriterion("s_discount <", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountLessThanOrEqualTo(String value) {
            addCriterion("s_discount <=", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountLike(String value) {
            addCriterion("s_discount like", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountNotLike(String value) {
            addCriterion("s_discount not like", value, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountIn(List<String> values) {
            addCriterion("s_discount in", values, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountNotIn(List<String> values) {
            addCriterion("s_discount not in", values, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountBetween(String value1, String value2) {
            addCriterion("s_discount between", value1, value2, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSDiscountNotBetween(String value1, String value2) {
            addCriterion("s_discount not between", value1, value2, "sDiscount");
            return (Criteria) this;
        }

        public Criteria andSPictureurlIsNull() {
            addCriterion("s_pictureUrl is null");
            return (Criteria) this;
        }

        public Criteria andSPictureurlIsNotNull() {
            addCriterion("s_pictureUrl is not null");
            return (Criteria) this;
        }

        public Criteria andSPictureurlEqualTo(String value) {
            addCriterion("s_pictureUrl =", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlNotEqualTo(String value) {
            addCriterion("s_pictureUrl <>", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlGreaterThan(String value) {
            addCriterion("s_pictureUrl >", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlGreaterThanOrEqualTo(String value) {
            addCriterion("s_pictureUrl >=", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlLessThan(String value) {
            addCriterion("s_pictureUrl <", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlLessThanOrEqualTo(String value) {
            addCriterion("s_pictureUrl <=", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlLike(String value) {
            addCriterion("s_pictureUrl like", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlNotLike(String value) {
            addCriterion("s_pictureUrl not like", value, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlIn(List<String> values) {
            addCriterion("s_pictureUrl in", values, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlNotIn(List<String> values) {
            addCriterion("s_pictureUrl not in", values, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlBetween(String value1, String value2) {
            addCriterion("s_pictureUrl between", value1, value2, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSPictureurlNotBetween(String value1, String value2) {
            addCriterion("s_pictureUrl not between", value1, value2, "sPictureurl");
            return (Criteria) this;
        }

        public Criteria andSBrandIsNull() {
            addCriterion("s_brand is null");
            return (Criteria) this;
        }

        public Criteria andSBrandIsNotNull() {
            addCriterion("s_brand is not null");
            return (Criteria) this;
        }

        public Criteria andSBrandEqualTo(String value) {
            addCriterion("s_brand =", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandNotEqualTo(String value) {
            addCriterion("s_brand <>", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandGreaterThan(String value) {
            addCriterion("s_brand >", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandGreaterThanOrEqualTo(String value) {
            addCriterion("s_brand >=", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandLessThan(String value) {
            addCriterion("s_brand <", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandLessThanOrEqualTo(String value) {
            addCriterion("s_brand <=", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandLike(String value) {
            addCriterion("s_brand like", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandNotLike(String value) {
            addCriterion("s_brand not like", value, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandIn(List<String> values) {
            addCriterion("s_brand in", values, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandNotIn(List<String> values) {
            addCriterion("s_brand not in", values, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandBetween(String value1, String value2) {
            addCriterion("s_brand between", value1, value2, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSBrandNotBetween(String value1, String value2) {
            addCriterion("s_brand not between", value1, value2, "sBrand");
            return (Criteria) this;
        }

        public Criteria andSPlaceIsNull() {
            addCriterion("s_place is null");
            return (Criteria) this;
        }

        public Criteria andSPlaceIsNotNull() {
            addCriterion("s_place is not null");
            return (Criteria) this;
        }

        public Criteria andSPlaceEqualTo(String value) {
            addCriterion("s_place =", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceNotEqualTo(String value) {
            addCriterion("s_place <>", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceGreaterThan(String value) {
            addCriterion("s_place >", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("s_place >=", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceLessThan(String value) {
            addCriterion("s_place <", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceLessThanOrEqualTo(String value) {
            addCriterion("s_place <=", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceLike(String value) {
            addCriterion("s_place like", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceNotLike(String value) {
            addCriterion("s_place not like", value, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceIn(List<String> values) {
            addCriterion("s_place in", values, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceNotIn(List<String> values) {
            addCriterion("s_place not in", values, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceBetween(String value1, String value2) {
            addCriterion("s_place between", value1, value2, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSPlaceNotBetween(String value1, String value2) {
            addCriterion("s_place not between", value1, value2, "sPlace");
            return (Criteria) this;
        }

        public Criteria andSImportedIsNull() {
            addCriterion("s_Imported is null");
            return (Criteria) this;
        }

        public Criteria andSImportedIsNotNull() {
            addCriterion("s_Imported is not null");
            return (Criteria) this;
        }

        public Criteria andSImportedEqualTo(Integer value) {
            addCriterion("s_Imported =", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedNotEqualTo(Integer value) {
            addCriterion("s_Imported <>", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedGreaterThan(Integer value) {
            addCriterion("s_Imported >", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_Imported >=", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedLessThan(Integer value) {
            addCriterion("s_Imported <", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedLessThanOrEqualTo(Integer value) {
            addCriterion("s_Imported <=", value, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedIn(List<Integer> values) {
            addCriterion("s_Imported in", values, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedNotIn(List<Integer> values) {
            addCriterion("s_Imported not in", values, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedBetween(Integer value1, Integer value2) {
            addCriterion("s_Imported between", value1, value2, "sImported");
            return (Criteria) this;
        }

        public Criteria andSImportedNotBetween(Integer value1, Integer value2) {
            addCriterion("s_Imported not between", value1, value2, "sImported");
            return (Criteria) this;
        }

        public Criteria andSScoreIsNull() {
            addCriterion("s_score is null");
            return (Criteria) this;
        }

        public Criteria andSScoreIsNotNull() {
            addCriterion("s_score is not null");
            return (Criteria) this;
        }

        public Criteria andSScoreEqualTo(Integer value) {
            addCriterion("s_score =", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreNotEqualTo(Integer value) {
            addCriterion("s_score <>", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreGreaterThan(Integer value) {
            addCriterion("s_score >", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_score >=", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreLessThan(Integer value) {
            addCriterion("s_score <", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreLessThanOrEqualTo(Integer value) {
            addCriterion("s_score <=", value, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreIn(List<Integer> values) {
            addCriterion("s_score in", values, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreNotIn(List<Integer> values) {
            addCriterion("s_score not in", values, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreBetween(Integer value1, Integer value2) {
            addCriterion("s_score between", value1, value2, "sScore");
            return (Criteria) this;
        }

        public Criteria andSScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("s_score not between", value1, value2, "sScore");
            return (Criteria) this;
        }

        public Criteria andSPdateIsNull() {
            addCriterion("s_pDate is null");
            return (Criteria) this;
        }

        public Criteria andSPdateIsNotNull() {
            addCriterion("s_pDate is not null");
            return (Criteria) this;
        }

        public Criteria andSPdateEqualTo(Date value) {
            addCriterionForJDBCDate("s_pDate =", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_pDate <>", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateGreaterThan(Date value) {
            addCriterionForJDBCDate("s_pDate >", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_pDate >=", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateLessThan(Date value) {
            addCriterionForJDBCDate("s_pDate <", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_pDate <=", value, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateIn(List<Date> values) {
            addCriterionForJDBCDate("s_pDate in", values, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_pDate not in", values, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_pDate between", value1, value2, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSPdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_pDate not between", value1, value2, "sPdate");
            return (Criteria) this;
        }

        public Criteria andSQdateIsNull() {
            addCriterion("s_qDate is null");
            return (Criteria) this;
        }

        public Criteria andSQdateIsNotNull() {
            addCriterion("s_qDate is not null");
            return (Criteria) this;
        }

        public Criteria andSQdateEqualTo(String value) {
            addCriterion("s_qDate =", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateNotEqualTo(String value) {
            addCriterion("s_qDate <>", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateGreaterThan(String value) {
            addCriterion("s_qDate >", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateGreaterThanOrEqualTo(String value) {
            addCriterion("s_qDate >=", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateLessThan(String value) {
            addCriterion("s_qDate <", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateLessThanOrEqualTo(String value) {
            addCriterion("s_qDate <=", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateLike(String value) {
            addCriterion("s_qDate like", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateNotLike(String value) {
            addCriterion("s_qDate not like", value, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateIn(List<String> values) {
            addCriterion("s_qDate in", values, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateNotIn(List<String> values) {
            addCriterion("s_qDate not in", values, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateBetween(String value1, String value2) {
            addCriterion("s_qDate between", value1, value2, "sQdate");
            return (Criteria) this;
        }

        public Criteria andSQdateNotBetween(String value1, String value2) {
            addCriterion("s_qDate not between", value1, value2, "sQdate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSCreatedateIsNull() {
            addCriterion("s_createDate is null");
            return (Criteria) this;
        }

        public Criteria andSCreatedateIsNotNull() {
            addCriterion("s_createDate is not null");
            return (Criteria) this;
        }

        public Criteria andSCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("s_createDate =", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_createDate <>", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("s_createDate >", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_createDate >=", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("s_createDate <", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_createDate <=", value, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("s_createDate in", values, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_createDate not in", values, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_createDate between", value1, value2, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_createDate not between", value1, value2, "sCreatedate");
            return (Criteria) this;
        }

        public Criteria andSDeseIsNull() {
            addCriterion("s_dese is null");
            return (Criteria) this;
        }

        public Criteria andSDeseIsNotNull() {
            addCriterion("s_dese is not null");
            return (Criteria) this;
        }

        public Criteria andSDeseEqualTo(String value) {
            addCriterion("s_dese =", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseNotEqualTo(String value) {
            addCriterion("s_dese <>", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseGreaterThan(String value) {
            addCriterion("s_dese >", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseGreaterThanOrEqualTo(String value) {
            addCriterion("s_dese >=", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseLessThan(String value) {
            addCriterion("s_dese <", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseLessThanOrEqualTo(String value) {
            addCriterion("s_dese <=", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseLike(String value) {
            addCriterion("s_dese like", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseNotLike(String value) {
            addCriterion("s_dese not like", value, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseIn(List<String> values) {
            addCriterion("s_dese in", values, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseNotIn(List<String> values) {
            addCriterion("s_dese not in", values, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseBetween(String value1, String value2) {
            addCriterion("s_dese between", value1, value2, "sDese");
            return (Criteria) this;
        }

        public Criteria andSDeseNotBetween(String value1, String value2) {
            addCriterion("s_dese not between", value1, value2, "sDese");
            return (Criteria) this;
        }

        public Criteria andSTypeIsNull() {
            addCriterion("s_type is null");
            return (Criteria) this;
        }

        public Criteria andSTypeIsNotNull() {
            addCriterion("s_type is not null");
            return (Criteria) this;
        }

        public Criteria andSTypeEqualTo(String value) {
            addCriterion("s_type =", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotEqualTo(String value) {
            addCriterion("s_type <>", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeGreaterThan(String value) {
            addCriterion("s_type >", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeGreaterThanOrEqualTo(String value) {
            addCriterion("s_type >=", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLessThan(String value) {
            addCriterion("s_type <", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLessThanOrEqualTo(String value) {
            addCriterion("s_type <=", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLike(String value) {
            addCriterion("s_type like", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotLike(String value) {
            addCriterion("s_type not like", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeIn(List<String> values) {
            addCriterion("s_type in", values, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotIn(List<String> values) {
            addCriterion("s_type not in", values, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeBetween(String value1, String value2) {
            addCriterion("s_type between", value1, value2, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotBetween(String value1, String value2) {
            addCriterion("s_type not between", value1, value2, "sType");
            return (Criteria) this;
        }

        public Criteria andSNumberIsNull() {
            addCriterion("s_number is null");
            return (Criteria) this;
        }

        public Criteria andSNumberIsNotNull() {
            addCriterion("s_number is not null");
            return (Criteria) this;
        }

        public Criteria andSNumberEqualTo(Integer value) {
            addCriterion("s_number =", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberNotEqualTo(Integer value) {
            addCriterion("s_number <>", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberGreaterThan(Integer value) {
            addCriterion("s_number >", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_number >=", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberLessThan(Integer value) {
            addCriterion("s_number <", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberLessThanOrEqualTo(Integer value) {
            addCriterion("s_number <=", value, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberIn(List<Integer> values) {
            addCriterion("s_number in", values, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberNotIn(List<Integer> values) {
            addCriterion("s_number not in", values, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberBetween(Integer value1, Integer value2) {
            addCriterion("s_number between", value1, value2, "sNumber");
            return (Criteria) this;
        }

        public Criteria andSNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("s_number not between", value1, value2, "sNumber");
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