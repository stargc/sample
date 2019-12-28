package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZHCGEnvironmentalCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZHCGEnvironmentalCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIsNull() {
            addCriterion("vehicle_no is null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIsNotNull() {
            addCriterion("vehicle_no is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoEqualTo(String value) {
            addCriterion("vehicle_no =", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotEqualTo(String value) {
            addCriterion("vehicle_no <>", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThan(String value) {
            addCriterion("vehicle_no >", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_no >=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThan(String value) {
            addCriterion("vehicle_no <", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThanOrEqualTo(String value) {
            addCriterion("vehicle_no <=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLike(String value) {
            addCriterion("vehicle_no like", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotLike(String value) {
            addCriterion("vehicle_no not like", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIn(List<String> values) {
            addCriterion("vehicle_no in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotIn(List<String> values) {
            addCriterion("vehicle_no not in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoBetween(String value1, String value2) {
            addCriterion("vehicle_no between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotBetween(String value1, String value2) {
            addCriterion("vehicle_no not between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("engine_no is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("engine_no is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("engine_no =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("engine_no <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("engine_no >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("engine_no >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("engine_no <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("engine_no <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("engine_no like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("engine_no not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("engine_no in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("engine_no not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("engine_no between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("engine_no not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andBrandModelIsNull() {
            addCriterion("brand_model is null");
            return (Criteria) this;
        }

        public Criteria andBrandModelIsNotNull() {
            addCriterion("brand_model is not null");
            return (Criteria) this;
        }

        public Criteria andBrandModelEqualTo(String value) {
            addCriterion("brand_model =", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelNotEqualTo(String value) {
            addCriterion("brand_model <>", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelGreaterThan(String value) {
            addCriterion("brand_model >", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelGreaterThanOrEqualTo(String value) {
            addCriterion("brand_model >=", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelLessThan(String value) {
            addCriterion("brand_model <", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelLessThanOrEqualTo(String value) {
            addCriterion("brand_model <=", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelLike(String value) {
            addCriterion("brand_model like", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelNotLike(String value) {
            addCriterion("brand_model not like", value, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelIn(List<String> values) {
            addCriterion("brand_model in", values, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelNotIn(List<String> values) {
            addCriterion("brand_model not in", values, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelBetween(String value1, String value2) {
            addCriterion("brand_model between", value1, value2, "brandModel");
            return (Criteria) this;
        }

        public Criteria andBrandModelNotBetween(String value1, String value2) {
            addCriterion("brand_model not between", value1, value2, "brandModel");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadIsNull() {
            addCriterion("vehicle_load is null");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadIsNotNull() {
            addCriterion("vehicle_load is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadEqualTo(String value) {
            addCriterion("vehicle_load =", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadNotEqualTo(String value) {
            addCriterion("vehicle_load <>", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadGreaterThan(String value) {
            addCriterion("vehicle_load >", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_load >=", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadLessThan(String value) {
            addCriterion("vehicle_load <", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadLessThanOrEqualTo(String value) {
            addCriterion("vehicle_load <=", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadLike(String value) {
            addCriterion("vehicle_load like", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadNotLike(String value) {
            addCriterion("vehicle_load not like", value, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadIn(List<String> values) {
            addCriterion("vehicle_load in", values, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadNotIn(List<String> values) {
            addCriterion("vehicle_load not in", values, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadBetween(String value1, String value2) {
            addCriterion("vehicle_load between", value1, value2, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleLoadNotBetween(String value1, String value2) {
            addCriterion("vehicle_load not between", value1, value2, "vehicleLoad");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameIsNull() {
            addCriterion("vehicle_typeName is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameIsNotNull() {
            addCriterion("vehicle_typeName is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameEqualTo(String value) {
            addCriterion("vehicle_typeName =", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameNotEqualTo(String value) {
            addCriterion("vehicle_typeName <>", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameGreaterThan(String value) {
            addCriterion("vehicle_typeName >", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_typeName >=", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameLessThan(String value) {
            addCriterion("vehicle_typeName <", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameLessThanOrEqualTo(String value) {
            addCriterion("vehicle_typeName <=", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameLike(String value) {
            addCriterion("vehicle_typeName like", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameNotLike(String value) {
            addCriterion("vehicle_typeName not like", value, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameIn(List<String> values) {
            addCriterion("vehicle_typeName in", values, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameNotIn(List<String> values) {
            addCriterion("vehicle_typeName not in", values, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameBetween(String value1, String value2) {
            addCriterion("vehicle_typeName between", value1, value2, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andVehicleTypenameNotBetween(String value1, String value2) {
            addCriterion("vehicle_typeName not between", value1, value2, "vehicleTypename");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameIsNull() {
            addCriterion("service_area_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameIsNotNull() {
            addCriterion("service_area_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameEqualTo(String value) {
            addCriterion("service_area_name =", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameNotEqualTo(String value) {
            addCriterion("service_area_name <>", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameGreaterThan(String value) {
            addCriterion("service_area_name >", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_area_name >=", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameLessThan(String value) {
            addCriterion("service_area_name <", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameLessThanOrEqualTo(String value) {
            addCriterion("service_area_name <=", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameLike(String value) {
            addCriterion("service_area_name like", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameNotLike(String value) {
            addCriterion("service_area_name not like", value, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameIn(List<String> values) {
            addCriterion("service_area_name in", values, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameNotIn(List<String> values) {
            addCriterion("service_area_name not in", values, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameBetween(String value1, String value2) {
            addCriterion("service_area_name between", value1, value2, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andServiceAreaNameNotBetween(String value1, String value2) {
            addCriterion("service_area_name not between", value1, value2, "serviceAreaName");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNull() {
            addCriterion("driver_name is null");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNotNull() {
            addCriterion("driver_name is not null");
            return (Criteria) this;
        }

        public Criteria andDriverNameEqualTo(String value) {
            addCriterion("driver_name =", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotEqualTo(String value) {
            addCriterion("driver_name <>", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThan(String value) {
            addCriterion("driver_name >", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThanOrEqualTo(String value) {
            addCriterion("driver_name >=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThan(String value) {
            addCriterion("driver_name <", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThanOrEqualTo(String value) {
            addCriterion("driver_name <=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLike(String value) {
            addCriterion("driver_name like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotLike(String value) {
            addCriterion("driver_name not like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameIn(List<String> values) {
            addCriterion("driver_name in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotIn(List<String> values) {
            addCriterion("driver_name not in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameBetween(String value1, String value2) {
            addCriterion("driver_name between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotBetween(String value1, String value2) {
            addCriterion("driver_name not between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeIsNull() {
            addCriterion("start_up_time is null");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeIsNotNull() {
            addCriterion("start_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeEqualTo(Date value) {
            addCriterion("start_up_time =", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeNotEqualTo(Date value) {
            addCriterion("start_up_time <>", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeGreaterThan(Date value) {
            addCriterion("start_up_time >", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_up_time >=", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeLessThan(Date value) {
            addCriterion("start_up_time <", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_up_time <=", value, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeIn(List<Date> values) {
            addCriterion("start_up_time in", values, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeNotIn(List<Date> values) {
            addCriterion("start_up_time not in", values, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeBetween(Date value1, Date value2) {
            addCriterion("start_up_time between", value1, value2, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andStartUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_up_time not between", value1, value2, "startUpTime");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeIsNull() {
            addCriterion("useful_life is null");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeIsNotNull() {
            addCriterion("useful_life is not null");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeEqualTo(String value) {
            addCriterion("useful_life =", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeNotEqualTo(String value) {
            addCriterion("useful_life <>", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeGreaterThan(String value) {
            addCriterion("useful_life >", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeGreaterThanOrEqualTo(String value) {
            addCriterion("useful_life >=", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeLessThan(String value) {
            addCriterion("useful_life <", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeLessThanOrEqualTo(String value) {
            addCriterion("useful_life <=", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeLike(String value) {
            addCriterion("useful_life like", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeNotLike(String value) {
            addCriterion("useful_life not like", value, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeIn(List<String> values) {
            addCriterion("useful_life in", values, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeNotIn(List<String> values) {
            addCriterion("useful_life not in", values, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeBetween(String value1, String value2) {
            addCriterion("useful_life between", value1, value2, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andUsefulLifeNotBetween(String value1, String value2) {
            addCriterion("useful_life not between", value1, value2, "usefulLife");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNull() {
            addCriterion("sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(String value) {
            addCriterion("sensor_id =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(String value) {
            addCriterion("sensor_id <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(String value) {
            addCriterion("sensor_id >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_id >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(String value) {
            addCriterion("sensor_id <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(String value) {
            addCriterion("sensor_id <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLike(String value) {
            addCriterion("sensor_id like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotLike(String value) {
            addCriterion("sensor_id not like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<String> values) {
            addCriterion("sensor_id in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<String> values) {
            addCriterion("sensor_id not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(String value1, String value2) {
            addCriterion("sensor_id between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(String value1, String value2) {
            addCriterion("sensor_id not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIsNull() {
            addCriterion("enclosure_url is null");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIsNotNull() {
            addCriterion("enclosure_url is not null");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlEqualTo(String value) {
            addCriterion("enclosure_url =", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotEqualTo(String value) {
            addCriterion("enclosure_url <>", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlGreaterThan(String value) {
            addCriterion("enclosure_url >", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("enclosure_url >=", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLessThan(String value) {
            addCriterion("enclosure_url <", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLessThanOrEqualTo(String value) {
            addCriterion("enclosure_url <=", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLike(String value) {
            addCriterion("enclosure_url like", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotLike(String value) {
            addCriterion("enclosure_url not like", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIn(List<String> values) {
            addCriterion("enclosure_url in", values, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotIn(List<String> values) {
            addCriterion("enclosure_url not in", values, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlBetween(String value1, String value2) {
            addCriterion("enclosure_url between", value1, value2, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotBetween(String value1, String value2) {
            addCriterion("enclosure_url not between", value1, value2, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andVehicleStateIsNull() {
            addCriterion("vehicle_state is null");
            return (Criteria) this;
        }

        public Criteria andVehicleStateIsNotNull() {
            addCriterion("vehicle_state is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleStateEqualTo(Integer value) {
            addCriterion("vehicle_state =", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateNotEqualTo(Integer value) {
            addCriterion("vehicle_state <>", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateGreaterThan(Integer value) {
            addCriterion("vehicle_state >", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_state >=", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateLessThan(Integer value) {
            addCriterion("vehicle_state <", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_state <=", value, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateIn(List<Integer> values) {
            addCriterion("vehicle_state in", values, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateNotIn(List<Integer> values) {
            addCriterion("vehicle_state not in", values, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_state between", value1, value2, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andVehicleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_state not between", value1, value2, "vehicleState");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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