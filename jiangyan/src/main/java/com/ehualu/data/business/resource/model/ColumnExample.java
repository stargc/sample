package com.ehualu.data.business.resource.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ColumnExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameIsNull() {
            addCriterion("resource_table_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameIsNotNull() {
            addCriterion("resource_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameEqualTo(String value) {
            addCriterion("resource_table_name =", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameNotEqualTo(String value) {
            addCriterion("resource_table_name <>", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameGreaterThan(String value) {
            addCriterion("resource_table_name >", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_table_name >=", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameLessThan(String value) {
            addCriterion("resource_table_name <", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameLessThanOrEqualTo(String value) {
            addCriterion("resource_table_name <=", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameLike(String value) {
            addCriterion("resource_table_name like", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameNotLike(String value) {
            addCriterion("resource_table_name not like", value, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameIn(List<String> values) {
            addCriterion("resource_table_name in", values, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameNotIn(List<String> values) {
            addCriterion("resource_table_name not in", values, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameBetween(String value1, String value2) {
            addCriterion("resource_table_name between", value1, value2, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableNameNotBetween(String value1, String value2) {
            addCriterion("resource_table_name not between", value1, value2, "resourceTableName");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeIsNull() {
            addCriterion("resource_table_code is null");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeIsNotNull() {
            addCriterion("resource_table_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeEqualTo(String value) {
            addCriterion("resource_table_code =", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeNotEqualTo(String value) {
            addCriterion("resource_table_code <>", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeGreaterThan(String value) {
            addCriterion("resource_table_code >", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_table_code >=", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeLessThan(String value) {
            addCriterion("resource_table_code <", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeLessThanOrEqualTo(String value) {
            addCriterion("resource_table_code <=", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeLike(String value) {
            addCriterion("resource_table_code like", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeNotLike(String value) {
            addCriterion("resource_table_code not like", value, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeIn(List<String> values) {
            addCriterion("resource_table_code in", values, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeNotIn(List<String> values) {
            addCriterion("resource_table_code not in", values, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeBetween(String value1, String value2) {
            addCriterion("resource_table_code between", value1, value2, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andResourceTableCodeNotBetween(String value1, String value2) {
            addCriterion("resource_table_code not between", value1, value2, "resourceTableCode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("des is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("des is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("des =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("des <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("des >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("des >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("des <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("des <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("des like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("des not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("des in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("des not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("des between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("des not between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Integer value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Integer value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Integer value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Integer value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Integer value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Integer> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Integer> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Integer value1, Integer value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeIsNull() {
            addCriterion("dict_table_code is null");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeIsNotNull() {
            addCriterion("dict_table_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeEqualTo(String value) {
            addCriterion("dict_table_code =", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeNotEqualTo(String value) {
            addCriterion("dict_table_code <>", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeGreaterThan(String value) {
            addCriterion("dict_table_code >", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_table_code >=", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeLessThan(String value) {
            addCriterion("dict_table_code <", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeLessThanOrEqualTo(String value) {
            addCriterion("dict_table_code <=", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeLike(String value) {
            addCriterion("dict_table_code like", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeNotLike(String value) {
            addCriterion("dict_table_code not like", value, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeIn(List<String> values) {
            addCriterion("dict_table_code in", values, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeNotIn(List<String> values) {
            addCriterion("dict_table_code not in", values, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeBetween(String value1, String value2) {
            addCriterion("dict_table_code between", value1, value2, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableCodeNotBetween(String value1, String value2) {
            addCriterion("dict_table_code not between", value1, value2, "dictTableCode");
            return (Criteria) this;
        }

        public Criteria andDictTableNameIsNull() {
            addCriterion("dict_table_name is null");
            return (Criteria) this;
        }

        public Criteria andDictTableNameIsNotNull() {
            addCriterion("dict_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictTableNameEqualTo(String value) {
            addCriterion("dict_table_name =", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameNotEqualTo(String value) {
            addCriterion("dict_table_name <>", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameGreaterThan(String value) {
            addCriterion("dict_table_name >", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_table_name >=", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameLessThan(String value) {
            addCriterion("dict_table_name <", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameLessThanOrEqualTo(String value) {
            addCriterion("dict_table_name <=", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameLike(String value) {
            addCriterion("dict_table_name like", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameNotLike(String value) {
            addCriterion("dict_table_name not like", value, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameIn(List<String> values) {
            addCriterion("dict_table_name in", values, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameNotIn(List<String> values) {
            addCriterion("dict_table_name not in", values, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameBetween(String value1, String value2) {
            addCriterion("dict_table_name between", value1, value2, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictTableNameNotBetween(String value1, String value2) {
            addCriterion("dict_table_name not between", value1, value2, "dictTableName");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeIsNull() {
            addCriterion("dict_group_code is null");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeIsNotNull() {
            addCriterion("dict_group_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeEqualTo(String value) {
            addCriterion("dict_group_code =", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeNotEqualTo(String value) {
            addCriterion("dict_group_code <>", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeGreaterThan(String value) {
            addCriterion("dict_group_code >", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_group_code >=", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeLessThan(String value) {
            addCriterion("dict_group_code <", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("dict_group_code <=", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeLike(String value) {
            addCriterion("dict_group_code like", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeNotLike(String value) {
            addCriterion("dict_group_code not like", value, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeIn(List<String> values) {
            addCriterion("dict_group_code in", values, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeNotIn(List<String> values) {
            addCriterion("dict_group_code not in", values, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeBetween(String value1, String value2) {
            addCriterion("dict_group_code between", value1, value2, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupCodeNotBetween(String value1, String value2) {
            addCriterion("dict_group_code not between", value1, value2, "dictGroupCode");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameIsNull() {
            addCriterion("dict_group_name is null");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameIsNotNull() {
            addCriterion("dict_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameEqualTo(String value) {
            addCriterion("dict_group_name =", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameNotEqualTo(String value) {
            addCriterion("dict_group_name <>", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameGreaterThan(String value) {
            addCriterion("dict_group_name >", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_group_name >=", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameLessThan(String value) {
            addCriterion("dict_group_name <", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameLessThanOrEqualTo(String value) {
            addCriterion("dict_group_name <=", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameLike(String value) {
            addCriterion("dict_group_name like", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameNotLike(String value) {
            addCriterion("dict_group_name not like", value, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameIn(List<String> values) {
            addCriterion("dict_group_name in", values, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameNotIn(List<String> values) {
            addCriterion("dict_group_name not in", values, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameBetween(String value1, String value2) {
            addCriterion("dict_group_name between", value1, value2, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andDictGroupNameNotBetween(String value1, String value2) {
            addCriterion("dict_group_name not between", value1, value2, "dictGroupName");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andSampleData1IsNull() {
            addCriterion("sample_data1 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData1IsNotNull() {
            addCriterion("sample_data1 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData1EqualTo(String value) {
            addCriterion("sample_data1 =", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1NotEqualTo(String value) {
            addCriterion("sample_data1 <>", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1GreaterThan(String value) {
            addCriterion("sample_data1 >", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data1 >=", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1LessThan(String value) {
            addCriterion("sample_data1 <", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1LessThanOrEqualTo(String value) {
            addCriterion("sample_data1 <=", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1Like(String value) {
            addCriterion("sample_data1 like", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1NotLike(String value) {
            addCriterion("sample_data1 not like", value, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1In(List<String> values) {
            addCriterion("sample_data1 in", values, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1NotIn(List<String> values) {
            addCriterion("sample_data1 not in", values, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1Between(String value1, String value2) {
            addCriterion("sample_data1 between", value1, value2, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData1NotBetween(String value1, String value2) {
            addCriterion("sample_data1 not between", value1, value2, "sampleData1");
            return (Criteria) this;
        }

        public Criteria andSampleData2IsNull() {
            addCriterion("sample_data2 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData2IsNotNull() {
            addCriterion("sample_data2 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData2EqualTo(String value) {
            addCriterion("sample_data2 =", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2NotEqualTo(String value) {
            addCriterion("sample_data2 <>", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2GreaterThan(String value) {
            addCriterion("sample_data2 >", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data2 >=", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2LessThan(String value) {
            addCriterion("sample_data2 <", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2LessThanOrEqualTo(String value) {
            addCriterion("sample_data2 <=", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2Like(String value) {
            addCriterion("sample_data2 like", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2NotLike(String value) {
            addCriterion("sample_data2 not like", value, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2In(List<String> values) {
            addCriterion("sample_data2 in", values, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2NotIn(List<String> values) {
            addCriterion("sample_data2 not in", values, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2Between(String value1, String value2) {
            addCriterion("sample_data2 between", value1, value2, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData2NotBetween(String value1, String value2) {
            addCriterion("sample_data2 not between", value1, value2, "sampleData2");
            return (Criteria) this;
        }

        public Criteria andSampleData3IsNull() {
            addCriterion("sample_data3 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData3IsNotNull() {
            addCriterion("sample_data3 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData3EqualTo(String value) {
            addCriterion("sample_data3 =", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3NotEqualTo(String value) {
            addCriterion("sample_data3 <>", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3GreaterThan(String value) {
            addCriterion("sample_data3 >", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data3 >=", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3LessThan(String value) {
            addCriterion("sample_data3 <", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3LessThanOrEqualTo(String value) {
            addCriterion("sample_data3 <=", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3Like(String value) {
            addCriterion("sample_data3 like", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3NotLike(String value) {
            addCriterion("sample_data3 not like", value, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3In(List<String> values) {
            addCriterion("sample_data3 in", values, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3NotIn(List<String> values) {
            addCriterion("sample_data3 not in", values, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3Between(String value1, String value2) {
            addCriterion("sample_data3 between", value1, value2, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData3NotBetween(String value1, String value2) {
            addCriterion("sample_data3 not between", value1, value2, "sampleData3");
            return (Criteria) this;
        }

        public Criteria andSampleData4IsNull() {
            addCriterion("sample_data4 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData4IsNotNull() {
            addCriterion("sample_data4 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData4EqualTo(String value) {
            addCriterion("sample_data4 =", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4NotEqualTo(String value) {
            addCriterion("sample_data4 <>", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4GreaterThan(String value) {
            addCriterion("sample_data4 >", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data4 >=", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4LessThan(String value) {
            addCriterion("sample_data4 <", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4LessThanOrEqualTo(String value) {
            addCriterion("sample_data4 <=", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4Like(String value) {
            addCriterion("sample_data4 like", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4NotLike(String value) {
            addCriterion("sample_data4 not like", value, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4In(List<String> values) {
            addCriterion("sample_data4 in", values, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4NotIn(List<String> values) {
            addCriterion("sample_data4 not in", values, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4Between(String value1, String value2) {
            addCriterion("sample_data4 between", value1, value2, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData4NotBetween(String value1, String value2) {
            addCriterion("sample_data4 not between", value1, value2, "sampleData4");
            return (Criteria) this;
        }

        public Criteria andSampleData5IsNull() {
            addCriterion("sample_data5 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData5IsNotNull() {
            addCriterion("sample_data5 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData5EqualTo(String value) {
            addCriterion("sample_data5 =", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5NotEqualTo(String value) {
            addCriterion("sample_data5 <>", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5GreaterThan(String value) {
            addCriterion("sample_data5 >", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data5 >=", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5LessThan(String value) {
            addCriterion("sample_data5 <", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5LessThanOrEqualTo(String value) {
            addCriterion("sample_data5 <=", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5Like(String value) {
            addCriterion("sample_data5 like", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5NotLike(String value) {
            addCriterion("sample_data5 not like", value, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5In(List<String> values) {
            addCriterion("sample_data5 in", values, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5NotIn(List<String> values) {
            addCriterion("sample_data5 not in", values, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5Between(String value1, String value2) {
            addCriterion("sample_data5 between", value1, value2, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData5NotBetween(String value1, String value2) {
            addCriterion("sample_data5 not between", value1, value2, "sampleData5");
            return (Criteria) this;
        }

        public Criteria andSampleData6IsNull() {
            addCriterion("sample_data6 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData6IsNotNull() {
            addCriterion("sample_data6 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData6EqualTo(String value) {
            addCriterion("sample_data6 =", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6NotEqualTo(String value) {
            addCriterion("sample_data6 <>", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6GreaterThan(String value) {
            addCriterion("sample_data6 >", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data6 >=", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6LessThan(String value) {
            addCriterion("sample_data6 <", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6LessThanOrEqualTo(String value) {
            addCriterion("sample_data6 <=", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6Like(String value) {
            addCriterion("sample_data6 like", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6NotLike(String value) {
            addCriterion("sample_data6 not like", value, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6In(List<String> values) {
            addCriterion("sample_data6 in", values, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6NotIn(List<String> values) {
            addCriterion("sample_data6 not in", values, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6Between(String value1, String value2) {
            addCriterion("sample_data6 between", value1, value2, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData6NotBetween(String value1, String value2) {
            addCriterion("sample_data6 not between", value1, value2, "sampleData6");
            return (Criteria) this;
        }

        public Criteria andSampleData7IsNull() {
            addCriterion("sample_data7 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData7IsNotNull() {
            addCriterion("sample_data7 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData7EqualTo(String value) {
            addCriterion("sample_data7 =", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7NotEqualTo(String value) {
            addCriterion("sample_data7 <>", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7GreaterThan(String value) {
            addCriterion("sample_data7 >", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data7 >=", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7LessThan(String value) {
            addCriterion("sample_data7 <", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7LessThanOrEqualTo(String value) {
            addCriterion("sample_data7 <=", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7Like(String value) {
            addCriterion("sample_data7 like", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7NotLike(String value) {
            addCriterion("sample_data7 not like", value, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7In(List<String> values) {
            addCriterion("sample_data7 in", values, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7NotIn(List<String> values) {
            addCriterion("sample_data7 not in", values, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7Between(String value1, String value2) {
            addCriterion("sample_data7 between", value1, value2, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData7NotBetween(String value1, String value2) {
            addCriterion("sample_data7 not between", value1, value2, "sampleData7");
            return (Criteria) this;
        }

        public Criteria andSampleData8IsNull() {
            addCriterion("sample_data8 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData8IsNotNull() {
            addCriterion("sample_data8 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData8EqualTo(String value) {
            addCriterion("sample_data8 =", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8NotEqualTo(String value) {
            addCriterion("sample_data8 <>", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8GreaterThan(String value) {
            addCriterion("sample_data8 >", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data8 >=", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8LessThan(String value) {
            addCriterion("sample_data8 <", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8LessThanOrEqualTo(String value) {
            addCriterion("sample_data8 <=", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8Like(String value) {
            addCriterion("sample_data8 like", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8NotLike(String value) {
            addCriterion("sample_data8 not like", value, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8In(List<String> values) {
            addCriterion("sample_data8 in", values, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8NotIn(List<String> values) {
            addCriterion("sample_data8 not in", values, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8Between(String value1, String value2) {
            addCriterion("sample_data8 between", value1, value2, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData8NotBetween(String value1, String value2) {
            addCriterion("sample_data8 not between", value1, value2, "sampleData8");
            return (Criteria) this;
        }

        public Criteria andSampleData9IsNull() {
            addCriterion("sample_data9 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData9IsNotNull() {
            addCriterion("sample_data9 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData9EqualTo(String value) {
            addCriterion("sample_data9 =", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9NotEqualTo(String value) {
            addCriterion("sample_data9 <>", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9GreaterThan(String value) {
            addCriterion("sample_data9 >", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data9 >=", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9LessThan(String value) {
            addCriterion("sample_data9 <", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9LessThanOrEqualTo(String value) {
            addCriterion("sample_data9 <=", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9Like(String value) {
            addCriterion("sample_data9 like", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9NotLike(String value) {
            addCriterion("sample_data9 not like", value, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9In(List<String> values) {
            addCriterion("sample_data9 in", values, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9NotIn(List<String> values) {
            addCriterion("sample_data9 not in", values, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9Between(String value1, String value2) {
            addCriterion("sample_data9 between", value1, value2, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData9NotBetween(String value1, String value2) {
            addCriterion("sample_data9 not between", value1, value2, "sampleData9");
            return (Criteria) this;
        }

        public Criteria andSampleData10IsNull() {
            addCriterion("sample_data10 is null");
            return (Criteria) this;
        }

        public Criteria andSampleData10IsNotNull() {
            addCriterion("sample_data10 is not null");
            return (Criteria) this;
        }

        public Criteria andSampleData10EqualTo(String value) {
            addCriterion("sample_data10 =", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10NotEqualTo(String value) {
            addCriterion("sample_data10 <>", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10GreaterThan(String value) {
            addCriterion("sample_data10 >", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10GreaterThanOrEqualTo(String value) {
            addCriterion("sample_data10 >=", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10LessThan(String value) {
            addCriterion("sample_data10 <", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10LessThanOrEqualTo(String value) {
            addCriterion("sample_data10 <=", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10Like(String value) {
            addCriterion("sample_data10 like", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10NotLike(String value) {
            addCriterion("sample_data10 not like", value, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10In(List<String> values) {
            addCriterion("sample_data10 in", values, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10NotIn(List<String> values) {
            addCriterion("sample_data10 not in", values, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10Between(String value1, String value2) {
            addCriterion("sample_data10 between", value1, value2, "sampleData10");
            return (Criteria) this;
        }

        public Criteria andSampleData10NotBetween(String value1, String value2) {
            addCriterion("sample_data10 not between", value1, value2, "sampleData10");
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