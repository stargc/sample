package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZHCGTrashExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZHCGTrashExample() {
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

        public Criteria andTrashIdIsNull() {
            addCriterion("trash_id is null");
            return (Criteria) this;
        }

        public Criteria andTrashIdIsNotNull() {
            addCriterion("trash_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrashIdEqualTo(Integer value) {
            addCriterion("trash_id =", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdNotEqualTo(Integer value) {
            addCriterion("trash_id <>", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdGreaterThan(Integer value) {
            addCriterion("trash_id >", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trash_id >=", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdLessThan(Integer value) {
            addCriterion("trash_id <", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdLessThanOrEqualTo(Integer value) {
            addCriterion("trash_id <=", value, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdIn(List<Integer> values) {
            addCriterion("trash_id in", values, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdNotIn(List<Integer> values) {
            addCriterion("trash_id not in", values, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdBetween(Integer value1, Integer value2) {
            addCriterion("trash_id between", value1, value2, "trashId");
            return (Criteria) this;
        }

        public Criteria andTrashIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trash_id not between", value1, value2, "trashId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNull() {
            addCriterion("street_name is null");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNotNull() {
            addCriterion("street_name is not null");
            return (Criteria) this;
        }

        public Criteria andStreetNameEqualTo(String value) {
            addCriterion("street_name =", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotEqualTo(String value) {
            addCriterion("street_name <>", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThan(String value) {
            addCriterion("street_name >", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThanOrEqualTo(String value) {
            addCriterion("street_name >=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThan(String value) {
            addCriterion("street_name <", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThanOrEqualTo(String value) {
            addCriterion("street_name <=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLike(String value) {
            addCriterion("street_name like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotLike(String value) {
            addCriterion("street_name not like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameIn(List<String> values) {
            addCriterion("street_name in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotIn(List<String> values) {
            addCriterion("street_name not in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameBetween(String value1, String value2) {
            addCriterion("street_name between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotBetween(String value1, String value2) {
            addCriterion("street_name not between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andRoadNameIsNull() {
            addCriterion("road_name is null");
            return (Criteria) this;
        }

        public Criteria andRoadNameIsNotNull() {
            addCriterion("road_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoadNameEqualTo(String value) {
            addCriterion("road_name =", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotEqualTo(String value) {
            addCriterion("road_name <>", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameGreaterThan(String value) {
            addCriterion("road_name >", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameGreaterThanOrEqualTo(String value) {
            addCriterion("road_name >=", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLessThan(String value) {
            addCriterion("road_name <", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLessThanOrEqualTo(String value) {
            addCriterion("road_name <=", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLike(String value) {
            addCriterion("road_name like", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotLike(String value) {
            addCriterion("road_name not like", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameIn(List<String> values) {
            addCriterion("road_name in", values, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotIn(List<String> values) {
            addCriterion("road_name not in", values, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameBetween(String value1, String value2) {
            addCriterion("road_name between", value1, value2, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotBetween(String value1, String value2) {
            addCriterion("road_name not between", value1, value2, "roadName");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNull() {
            addCriterion("street_id is null");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNotNull() {
            addCriterion("street_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreetIdEqualTo(Integer value) {
            addCriterion("street_id =", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotEqualTo(Integer value) {
            addCriterion("street_id <>", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThan(Integer value) {
            addCriterion("street_id >", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("street_id >=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThan(Integer value) {
            addCriterion("street_id <", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThanOrEqualTo(Integer value) {
            addCriterion("street_id <=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIn(List<Integer> values) {
            addCriterion("street_id in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotIn(List<Integer> values) {
            addCriterion("street_id not in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdBetween(Integer value1, Integer value2) {
            addCriterion("street_id between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("street_id not between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andRoadIdIsNull() {
            addCriterion("road_id is null");
            return (Criteria) this;
        }

        public Criteria andRoadIdIsNotNull() {
            addCriterion("road_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoadIdEqualTo(Integer value) {
            addCriterion("road_id =", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdNotEqualTo(Integer value) {
            addCriterion("road_id <>", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdGreaterThan(Integer value) {
            addCriterion("road_id >", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("road_id >=", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdLessThan(Integer value) {
            addCriterion("road_id <", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdLessThanOrEqualTo(Integer value) {
            addCriterion("road_id <=", value, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdIn(List<Integer> values) {
            addCriterion("road_id in", values, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdNotIn(List<Integer> values) {
            addCriterion("road_id not in", values, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdBetween(Integer value1, Integer value2) {
            addCriterion("road_id between", value1, value2, "roadId");
            return (Criteria) this;
        }

        public Criteria andRoadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("road_id not between", value1, value2, "roadId");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
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

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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

        public Criteria andTrashStateIsNull() {
            addCriterion("trash_state is null");
            return (Criteria) this;
        }

        public Criteria andTrashStateIsNotNull() {
            addCriterion("trash_state is not null");
            return (Criteria) this;
        }

        public Criteria andTrashStateEqualTo(String value) {
            addCriterion("trash_state =", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateNotEqualTo(String value) {
            addCriterion("trash_state <>", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateGreaterThan(String value) {
            addCriterion("trash_state >", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateGreaterThanOrEqualTo(String value) {
            addCriterion("trash_state >=", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateLessThan(String value) {
            addCriterion("trash_state <", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateLessThanOrEqualTo(String value) {
            addCriterion("trash_state <=", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateLike(String value) {
            addCriterion("trash_state like", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateNotLike(String value) {
            addCriterion("trash_state not like", value, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateIn(List<String> values) {
            addCriterion("trash_state in", values, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateNotIn(List<String> values) {
            addCriterion("trash_state not in", values, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateBetween(String value1, String value2) {
            addCriterion("trash_state between", value1, value2, "trashState");
            return (Criteria) this;
        }

        public Criteria andTrashStateNotBetween(String value1, String value2) {
            addCriterion("trash_state not between", value1, value2, "trashState");
            return (Criteria) this;
        }

        public Criteria andWarningIsNull() {
            addCriterion("warning is null");
            return (Criteria) this;
        }

        public Criteria andWarningIsNotNull() {
            addCriterion("warning is not null");
            return (Criteria) this;
        }

        public Criteria andWarningEqualTo(Integer value) {
            addCriterion("warning =", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotEqualTo(Integer value) {
            addCriterion("warning <>", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningGreaterThan(Integer value) {
            addCriterion("warning >", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning >=", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningLessThan(Integer value) {
            addCriterion("warning <", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningLessThanOrEqualTo(Integer value) {
            addCriterion("warning <=", value, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningIn(List<Integer> values) {
            addCriterion("warning in", values, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotIn(List<Integer> values) {
            addCriterion("warning not in", values, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningBetween(Integer value1, Integer value2) {
            addCriterion("warning between", value1, value2, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningNotBetween(Integer value1, Integer value2) {
            addCriterion("warning not between", value1, value2, "warning");
            return (Criteria) this;
        }

        public Criteria andWarningTimeIsNull() {
            addCriterion("warning_time is null");
            return (Criteria) this;
        }

        public Criteria andWarningTimeIsNotNull() {
            addCriterion("warning_time is not null");
            return (Criteria) this;
        }

        public Criteria andWarningTimeEqualTo(Date value) {
            addCriterion("warning_time =", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeNotEqualTo(Date value) {
            addCriterion("warning_time <>", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeGreaterThan(Date value) {
            addCriterion("warning_time >", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warning_time >=", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeLessThan(Date value) {
            addCriterion("warning_time <", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeLessThanOrEqualTo(Date value) {
            addCriterion("warning_time <=", value, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeIn(List<Date> values) {
            addCriterion("warning_time in", values, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeNotIn(List<Date> values) {
            addCriterion("warning_time not in", values, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeBetween(Date value1, Date value2) {
            addCriterion("warning_time between", value1, value2, "warningTime");
            return (Criteria) this;
        }

        public Criteria andWarningTimeNotBetween(Date value1, Date value2) {
            addCriterion("warning_time not between", value1, value2, "warningTime");
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