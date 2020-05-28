package com.ehualu.data.business.resource.model;

import java.util.ArrayList;
import java.util.List;

public class TableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableExample() {
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

    protected int startRow;

    protected int pageSize;


    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

        public Criteria andResourceCodeIsNull() {
            addCriterion("resource_code is null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIsNotNull() {
            addCriterion("resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeEqualTo(String value) {
            addCriterion("resource_code =", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotEqualTo(String value) {
            addCriterion("resource_code <>", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThan(String value) {
            addCriterion("resource_code >", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_code >=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThan(String value) {
            addCriterion("resource_code <", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("resource_code <=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLike(String value) {
            addCriterion("resource_code like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotLike(String value) {
            addCriterion("resource_code not like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIn(List<String> values) {
            addCriterion("resource_code in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotIn(List<String> values) {
            addCriterion("resource_code not in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeBetween(String value1, String value2) {
            addCriterion("resource_code between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotBetween(String value1, String value2) {
            addCriterion("resource_code not between", value1, value2, "resourceCode");
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

        public Criteria andTablePhysicalNameIsNull() {
            addCriterion("table_physical_name is null");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameIsNotNull() {
            addCriterion("table_physical_name is not null");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameEqualTo(String value) {
            addCriterion("table_physical_name =", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameNotEqualTo(String value) {
            addCriterion("table_physical_name <>", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameGreaterThan(String value) {
            addCriterion("table_physical_name >", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_physical_name >=", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameLessThan(String value) {
            addCriterion("table_physical_name <", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameLessThanOrEqualTo(String value) {
            addCriterion("table_physical_name <=", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameLike(String value) {
            addCriterion("table_physical_name like", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameNotLike(String value) {
            addCriterion("table_physical_name not like", value, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameIn(List<String> values) {
            addCriterion("table_physical_name in", values, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameNotIn(List<String> values) {
            addCriterion("table_physical_name not in", values, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameBetween(String value1, String value2) {
            addCriterion("table_physical_name between", value1, value2, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andTablePhysicalNameNotBetween(String value1, String value2) {
            addCriterion("table_physical_name not between", value1, value2, "tablePhysicalName");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Long value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Long value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Long value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Long value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Long value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Long value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Long> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Long> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Long value1, Long value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Long value1, Long value2) {
            addCriterion("count not between", value1, value2, "count");
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