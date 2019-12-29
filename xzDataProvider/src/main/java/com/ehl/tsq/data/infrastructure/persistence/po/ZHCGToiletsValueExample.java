package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZHCGToiletsValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZHCGToiletsValueExample() {
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

        public Criteria andToiletIdIsNull() {
            addCriterion("toilet_id is null");
            return (Criteria) this;
        }

        public Criteria andToiletIdIsNotNull() {
            addCriterion("toilet_id is not null");
            return (Criteria) this;
        }

        public Criteria andToiletIdEqualTo(Integer value) {
            addCriterion("toilet_id =", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdNotEqualTo(Integer value) {
            addCriterion("toilet_id <>", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdGreaterThan(Integer value) {
            addCriterion("toilet_id >", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("toilet_id >=", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdLessThan(Integer value) {
            addCriterion("toilet_id <", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdLessThanOrEqualTo(Integer value) {
            addCriterion("toilet_id <=", value, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdIn(List<Integer> values) {
            addCriterion("toilet_id in", values, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdNotIn(List<Integer> values) {
            addCriterion("toilet_id not in", values, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdBetween(Integer value1, Integer value2) {
            addCriterion("toilet_id between", value1, value2, "toiletId");
            return (Criteria) this;
        }

        public Criteria andToiletIdNotBetween(Integer value1, Integer value2) {
            addCriterion("toilet_id not between", value1, value2, "toiletId");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNull() {
            addCriterion("device_num is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNotNull() {
            addCriterion("device_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumEqualTo(String value) {
            addCriterion("device_num =", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotEqualTo(String value) {
            addCriterion("device_num <>", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThan(String value) {
            addCriterion("device_num >", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThanOrEqualTo(String value) {
            addCriterion("device_num >=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThan(String value) {
            addCriterion("device_num <", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThanOrEqualTo(String value) {
            addCriterion("device_num <=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLike(String value) {
            addCriterion("device_num like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotLike(String value) {
            addCriterion("device_num not like", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIn(List<String> values) {
            addCriterion("device_num in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotIn(List<String> values) {
            addCriterion("device_num not in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumBetween(String value1, String value2) {
            addCriterion("device_num between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotBetween(String value1, String value2) {
            addCriterion("device_num not between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andCh4IsNull() {
            addCriterion("cH4 is null");
            return (Criteria) this;
        }

        public Criteria andCh4IsNotNull() {
            addCriterion("cH4 is not null");
            return (Criteria) this;
        }

        public Criteria andCh4EqualTo(String value) {
            addCriterion("cH4 =", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4NotEqualTo(String value) {
            addCriterion("cH4 <>", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4GreaterThan(String value) {
            addCriterion("cH4 >", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4GreaterThanOrEqualTo(String value) {
            addCriterion("cH4 >=", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4LessThan(String value) {
            addCriterion("cH4 <", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4LessThanOrEqualTo(String value) {
            addCriterion("cH4 <=", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4Like(String value) {
            addCriterion("cH4 like", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4NotLike(String value) {
            addCriterion("cH4 not like", value, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4In(List<String> values) {
            addCriterion("cH4 in", values, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4NotIn(List<String> values) {
            addCriterion("cH4 not in", values, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4Between(String value1, String value2) {
            addCriterion("cH4 between", value1, value2, "ch4");
            return (Criteria) this;
        }

        public Criteria andCh4NotBetween(String value1, String value2) {
            addCriterion("cH4 not between", value1, value2, "ch4");
            return (Criteria) this;
        }

        public Criteria andCoIsNull() {
            addCriterion("cO is null");
            return (Criteria) this;
        }

        public Criteria andCoIsNotNull() {
            addCriterion("cO is not null");
            return (Criteria) this;
        }

        public Criteria andCoEqualTo(String value) {
            addCriterion("cO =", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotEqualTo(String value) {
            addCriterion("cO <>", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThan(String value) {
            addCriterion("cO >", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoGreaterThanOrEqualTo(String value) {
            addCriterion("cO >=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThan(String value) {
            addCriterion("cO <", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLessThanOrEqualTo(String value) {
            addCriterion("cO <=", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoLike(String value) {
            addCriterion("cO like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotLike(String value) {
            addCriterion("cO not like", value, "co");
            return (Criteria) this;
        }

        public Criteria andCoIn(List<String> values) {
            addCriterion("cO in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotIn(List<String> values) {
            addCriterion("cO not in", values, "co");
            return (Criteria) this;
        }

        public Criteria andCoBetween(String value1, String value2) {
            addCriterion("cO between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCoNotBetween(String value1, String value2) {
            addCriterion("cO not between", value1, value2, "co");
            return (Criteria) this;
        }

        public Criteria andCo2IsNull() {
            addCriterion("cO2 is null");
            return (Criteria) this;
        }

        public Criteria andCo2IsNotNull() {
            addCriterion("cO2 is not null");
            return (Criteria) this;
        }

        public Criteria andCo2EqualTo(String value) {
            addCriterion("cO2 =", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotEqualTo(String value) {
            addCriterion("cO2 <>", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2GreaterThan(String value) {
            addCriterion("cO2 >", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2GreaterThanOrEqualTo(String value) {
            addCriterion("cO2 >=", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2LessThan(String value) {
            addCriterion("cO2 <", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2LessThanOrEqualTo(String value) {
            addCriterion("cO2 <=", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2Like(String value) {
            addCriterion("cO2 like", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotLike(String value) {
            addCriterion("cO2 not like", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2In(List<String> values) {
            addCriterion("cO2 in", values, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotIn(List<String> values) {
            addCriterion("cO2 not in", values, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2Between(String value1, String value2) {
            addCriterion("cO2 between", value1, value2, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotBetween(String value1, String value2) {
            addCriterion("cO2 not between", value1, value2, "co2");
            return (Criteria) this;
        }

        public Criteria andDbIsNull() {
            addCriterion("dB is null");
            return (Criteria) this;
        }

        public Criteria andDbIsNotNull() {
            addCriterion("dB is not null");
            return (Criteria) this;
        }

        public Criteria andDbEqualTo(String value) {
            addCriterion("dB =", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotEqualTo(String value) {
            addCriterion("dB <>", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbGreaterThan(String value) {
            addCriterion("dB >", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbGreaterThanOrEqualTo(String value) {
            addCriterion("dB >=", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLessThan(String value) {
            addCriterion("dB <", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLessThanOrEqualTo(String value) {
            addCriterion("dB <=", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLike(String value) {
            addCriterion("dB like", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotLike(String value) {
            addCriterion("dB not like", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbIn(List<String> values) {
            addCriterion("dB in", values, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotIn(List<String> values) {
            addCriterion("dB not in", values, "db");
            return (Criteria) this;
        }

        public Criteria andDbBetween(String value1, String value2) {
            addCriterion("dB between", value1, value2, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotBetween(String value1, String value2) {
            addCriterion("dB not between", value1, value2, "db");
            return (Criteria) this;
        }

        public Criteria andH2IsNull() {
            addCriterion("h2 is null");
            return (Criteria) this;
        }

        public Criteria andH2IsNotNull() {
            addCriterion("h2 is not null");
            return (Criteria) this;
        }

        public Criteria andH2EqualTo(String value) {
            addCriterion("h2 =", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotEqualTo(String value) {
            addCriterion("h2 <>", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2GreaterThan(String value) {
            addCriterion("h2 >", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2GreaterThanOrEqualTo(String value) {
            addCriterion("h2 >=", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2LessThan(String value) {
            addCriterion("h2 <", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2LessThanOrEqualTo(String value) {
            addCriterion("h2 <=", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2Like(String value) {
            addCriterion("h2 like", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotLike(String value) {
            addCriterion("h2 not like", value, "h2");
            return (Criteria) this;
        }

        public Criteria andH2In(List<String> values) {
            addCriterion("h2 in", values, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotIn(List<String> values) {
            addCriterion("h2 not in", values, "h2");
            return (Criteria) this;
        }

        public Criteria andH2Between(String value1, String value2) {
            addCriterion("h2 between", value1, value2, "h2");
            return (Criteria) this;
        }

        public Criteria andH2NotBetween(String value1, String value2) {
            addCriterion("h2 not between", value1, value2, "h2");
            return (Criteria) this;
        }

        public Criteria andH2sIsNull() {
            addCriterion("h2S is null");
            return (Criteria) this;
        }

        public Criteria andH2sIsNotNull() {
            addCriterion("h2S is not null");
            return (Criteria) this;
        }

        public Criteria andH2sEqualTo(String value) {
            addCriterion("h2S =", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sNotEqualTo(String value) {
            addCriterion("h2S <>", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sGreaterThan(String value) {
            addCriterion("h2S >", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sGreaterThanOrEqualTo(String value) {
            addCriterion("h2S >=", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sLessThan(String value) {
            addCriterion("h2S <", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sLessThanOrEqualTo(String value) {
            addCriterion("h2S <=", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sLike(String value) {
            addCriterion("h2S like", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sNotLike(String value) {
            addCriterion("h2S not like", value, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sIn(List<String> values) {
            addCriterion("h2S in", values, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sNotIn(List<String> values) {
            addCriterion("h2S not in", values, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sBetween(String value1, String value2) {
            addCriterion("h2S between", value1, value2, "h2s");
            return (Criteria) this;
        }

        public Criteria andH2sNotBetween(String value1, String value2) {
            addCriterion("h2S not between", value1, value2, "h2s");
            return (Criteria) this;
        }

        public Criteria andHchoIsNull() {
            addCriterion("hCHO is null");
            return (Criteria) this;
        }

        public Criteria andHchoIsNotNull() {
            addCriterion("hCHO is not null");
            return (Criteria) this;
        }

        public Criteria andHchoEqualTo(String value) {
            addCriterion("hCHO =", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoNotEqualTo(String value) {
            addCriterion("hCHO <>", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoGreaterThan(String value) {
            addCriterion("hCHO >", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoGreaterThanOrEqualTo(String value) {
            addCriterion("hCHO >=", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoLessThan(String value) {
            addCriterion("hCHO <", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoLessThanOrEqualTo(String value) {
            addCriterion("hCHO <=", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoLike(String value) {
            addCriterion("hCHO like", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoNotLike(String value) {
            addCriterion("hCHO not like", value, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoIn(List<String> values) {
            addCriterion("hCHO in", values, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoNotIn(List<String> values) {
            addCriterion("hCHO not in", values, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoBetween(String value1, String value2) {
            addCriterion("hCHO between", value1, value2, "hcho");
            return (Criteria) this;
        }

        public Criteria andHchoNotBetween(String value1, String value2) {
            addCriterion("hCHO not between", value1, value2, "hcho");
            return (Criteria) this;
        }

        public Criteria andMpaIsNull() {
            addCriterion("mPA is null");
            return (Criteria) this;
        }

        public Criteria andMpaIsNotNull() {
            addCriterion("mPA is not null");
            return (Criteria) this;
        }

        public Criteria andMpaEqualTo(String value) {
            addCriterion("mPA =", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaNotEqualTo(String value) {
            addCriterion("mPA <>", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaGreaterThan(String value) {
            addCriterion("mPA >", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaGreaterThanOrEqualTo(String value) {
            addCriterion("mPA >=", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaLessThan(String value) {
            addCriterion("mPA <", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaLessThanOrEqualTo(String value) {
            addCriterion("mPA <=", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaLike(String value) {
            addCriterion("mPA like", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaNotLike(String value) {
            addCriterion("mPA not like", value, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaIn(List<String> values) {
            addCriterion("mPA in", values, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaNotIn(List<String> values) {
            addCriterion("mPA not in", values, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaBetween(String value1, String value2) {
            addCriterion("mPA between", value1, value2, "mpa");
            return (Criteria) this;
        }

        public Criteria andMpaNotBetween(String value1, String value2) {
            addCriterion("mPA not between", value1, value2, "mpa");
            return (Criteria) this;
        }

        public Criteria andNh3IsNull() {
            addCriterion("nH3 is null");
            return (Criteria) this;
        }

        public Criteria andNh3IsNotNull() {
            addCriterion("nH3 is not null");
            return (Criteria) this;
        }

        public Criteria andNh3EqualTo(String value) {
            addCriterion("nH3 =", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3NotEqualTo(String value) {
            addCriterion("nH3 <>", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3GreaterThan(String value) {
            addCriterion("nH3 >", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3GreaterThanOrEqualTo(String value) {
            addCriterion("nH3 >=", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3LessThan(String value) {
            addCriterion("nH3 <", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3LessThanOrEqualTo(String value) {
            addCriterion("nH3 <=", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3Like(String value) {
            addCriterion("nH3 like", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3NotLike(String value) {
            addCriterion("nH3 not like", value, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3In(List<String> values) {
            addCriterion("nH3 in", values, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3NotIn(List<String> values) {
            addCriterion("nH3 not in", values, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3Between(String value1, String value2) {
            addCriterion("nH3 between", value1, value2, "nh3");
            return (Criteria) this;
        }

        public Criteria andNh3NotBetween(String value1, String value2) {
            addCriterion("nH3 not between", value1, value2, "nh3");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("nO is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("nO is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("nO =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("nO <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("nO >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("nO >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("nO <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("nO <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("nO like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("nO not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("nO in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("nO not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("nO between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("nO not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNo2IsNull() {
            addCriterion("nO2 is null");
            return (Criteria) this;
        }

        public Criteria andNo2IsNotNull() {
            addCriterion("nO2 is not null");
            return (Criteria) this;
        }

        public Criteria andNo2EqualTo(String value) {
            addCriterion("nO2 =", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotEqualTo(String value) {
            addCriterion("nO2 <>", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThan(String value) {
            addCriterion("nO2 >", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2GreaterThanOrEqualTo(String value) {
            addCriterion("nO2 >=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThan(String value) {
            addCriterion("nO2 <", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2LessThanOrEqualTo(String value) {
            addCriterion("nO2 <=", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Like(String value) {
            addCriterion("nO2 like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotLike(String value) {
            addCriterion("nO2 not like", value, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2In(List<String> values) {
            addCriterion("nO2 in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotIn(List<String> values) {
            addCriterion("nO2 not in", values, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2Between(String value1, String value2) {
            addCriterion("nO2 between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNo2NotBetween(String value1, String value2) {
            addCriterion("nO2 not between", value1, value2, "no2");
            return (Criteria) this;
        }

        public Criteria andNoiIsNull() {
            addCriterion("nOI is null");
            return (Criteria) this;
        }

        public Criteria andNoiIsNotNull() {
            addCriterion("nOI is not null");
            return (Criteria) this;
        }

        public Criteria andNoiEqualTo(String value) {
            addCriterion("nOI =", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiNotEqualTo(String value) {
            addCriterion("nOI <>", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiGreaterThan(String value) {
            addCriterion("nOI >", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiGreaterThanOrEqualTo(String value) {
            addCriterion("nOI >=", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiLessThan(String value) {
            addCriterion("nOI <", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiLessThanOrEqualTo(String value) {
            addCriterion("nOI <=", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiLike(String value) {
            addCriterion("nOI like", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiNotLike(String value) {
            addCriterion("nOI not like", value, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiIn(List<String> values) {
            addCriterion("nOI in", values, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiNotIn(List<String> values) {
            addCriterion("nOI not in", values, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiBetween(String value1, String value2) {
            addCriterion("nOI between", value1, value2, "noi");
            return (Criteria) this;
        }

        public Criteria andNoiNotBetween(String value1, String value2) {
            addCriterion("nOI not between", value1, value2, "noi");
            return (Criteria) this;
        }

        public Criteria andO2IsNull() {
            addCriterion("o2 is null");
            return (Criteria) this;
        }

        public Criteria andO2IsNotNull() {
            addCriterion("o2 is not null");
            return (Criteria) this;
        }

        public Criteria andO2EqualTo(String value) {
            addCriterion("o2 =", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2NotEqualTo(String value) {
            addCriterion("o2 <>", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2GreaterThan(String value) {
            addCriterion("o2 >", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2GreaterThanOrEqualTo(String value) {
            addCriterion("o2 >=", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2LessThan(String value) {
            addCriterion("o2 <", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2LessThanOrEqualTo(String value) {
            addCriterion("o2 <=", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2Like(String value) {
            addCriterion("o2 like", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2NotLike(String value) {
            addCriterion("o2 not like", value, "o2");
            return (Criteria) this;
        }

        public Criteria andO2In(List<String> values) {
            addCriterion("o2 in", values, "o2");
            return (Criteria) this;
        }

        public Criteria andO2NotIn(List<String> values) {
            addCriterion("o2 not in", values, "o2");
            return (Criteria) this;
        }

        public Criteria andO2Between(String value1, String value2) {
            addCriterion("o2 between", value1, value2, "o2");
            return (Criteria) this;
        }

        public Criteria andO2NotBetween(String value1, String value2) {
            addCriterion("o2 not between", value1, value2, "o2");
            return (Criteria) this;
        }

        public Criteria andO3IsNull() {
            addCriterion("o3 is null");
            return (Criteria) this;
        }

        public Criteria andO3IsNotNull() {
            addCriterion("o3 is not null");
            return (Criteria) this;
        }

        public Criteria andO3EqualTo(String value) {
            addCriterion("o3 =", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotEqualTo(String value) {
            addCriterion("o3 <>", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThan(String value) {
            addCriterion("o3 >", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3GreaterThanOrEqualTo(String value) {
            addCriterion("o3 >=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThan(String value) {
            addCriterion("o3 <", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3LessThanOrEqualTo(String value) {
            addCriterion("o3 <=", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Like(String value) {
            addCriterion("o3 like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotLike(String value) {
            addCriterion("o3 not like", value, "o3");
            return (Criteria) this;
        }

        public Criteria andO3In(List<String> values) {
            addCriterion("o3 in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotIn(List<String> values) {
            addCriterion("o3 not in", values, "o3");
            return (Criteria) this;
        }

        public Criteria andO3Between(String value1, String value2) {
            addCriterion("o3 between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andO3NotBetween(String value1, String value2) {
            addCriterion("o3 not between", value1, value2, "o3");
            return (Criteria) this;
        }

        public Criteria andPm10IsNull() {
            addCriterion("pM10 is null");
            return (Criteria) this;
        }

        public Criteria andPm10IsNotNull() {
            addCriterion("pM10 is not null");
            return (Criteria) this;
        }

        public Criteria andPm10EqualTo(String value) {
            addCriterion("pM10 =", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotEqualTo(String value) {
            addCriterion("pM10 <>", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThan(String value) {
            addCriterion("pM10 >", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThanOrEqualTo(String value) {
            addCriterion("pM10 >=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThan(String value) {
            addCriterion("pM10 <", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThanOrEqualTo(String value) {
            addCriterion("pM10 <=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Like(String value) {
            addCriterion("pM10 like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotLike(String value) {
            addCriterion("pM10 not like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10In(List<String> values) {
            addCriterion("pM10 in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotIn(List<String> values) {
            addCriterion("pM10 not in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Between(String value1, String value2) {
            addCriterion("pM10 between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotBetween(String value1, String value2) {
            addCriterion("pM10 not between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm25IsNull() {
            addCriterion("pM25 is null");
            return (Criteria) this;
        }

        public Criteria andPm25IsNotNull() {
            addCriterion("pM25 is not null");
            return (Criteria) this;
        }

        public Criteria andPm25EqualTo(String value) {
            addCriterion("pM25 =", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotEqualTo(String value) {
            addCriterion("pM25 <>", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThan(String value) {
            addCriterion("pM25 >", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThanOrEqualTo(String value) {
            addCriterion("pM25 >=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThan(String value) {
            addCriterion("pM25 <", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThanOrEqualTo(String value) {
            addCriterion("pM25 <=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Like(String value) {
            addCriterion("pM25 like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotLike(String value) {
            addCriterion("pM25 not like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25In(List<String> values) {
            addCriterion("pM25 in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotIn(List<String> values) {
            addCriterion("pM25 not in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Between(String value1, String value2) {
            addCriterion("pM25 between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotBetween(String value1, String value2) {
            addCriterion("pM25 not between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andSmogIsNull() {
            addCriterion("sMOG is null");
            return (Criteria) this;
        }

        public Criteria andSmogIsNotNull() {
            addCriterion("sMOG is not null");
            return (Criteria) this;
        }

        public Criteria andSmogEqualTo(String value) {
            addCriterion("sMOG =", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogNotEqualTo(String value) {
            addCriterion("sMOG <>", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogGreaterThan(String value) {
            addCriterion("sMOG >", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogGreaterThanOrEqualTo(String value) {
            addCriterion("sMOG >=", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogLessThan(String value) {
            addCriterion("sMOG <", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogLessThanOrEqualTo(String value) {
            addCriterion("sMOG <=", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogLike(String value) {
            addCriterion("sMOG like", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogNotLike(String value) {
            addCriterion("sMOG not like", value, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogIn(List<String> values) {
            addCriterion("sMOG in", values, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogNotIn(List<String> values) {
            addCriterion("sMOG not in", values, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogBetween(String value1, String value2) {
            addCriterion("sMOG between", value1, value2, "smog");
            return (Criteria) this;
        }

        public Criteria andSmogNotBetween(String value1, String value2) {
            addCriterion("sMOG not between", value1, value2, "smog");
            return (Criteria) this;
        }

        public Criteria andSo2IsNull() {
            addCriterion("sO2 is null");
            return (Criteria) this;
        }

        public Criteria andSo2IsNotNull() {
            addCriterion("sO2 is not null");
            return (Criteria) this;
        }

        public Criteria andSo2EqualTo(String value) {
            addCriterion("sO2 =", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotEqualTo(String value) {
            addCriterion("sO2 <>", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThan(String value) {
            addCriterion("sO2 >", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2GreaterThanOrEqualTo(String value) {
            addCriterion("sO2 >=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThan(String value) {
            addCriterion("sO2 <", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2LessThanOrEqualTo(String value) {
            addCriterion("sO2 <=", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Like(String value) {
            addCriterion("sO2 like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotLike(String value) {
            addCriterion("sO2 not like", value, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2In(List<String> values) {
            addCriterion("sO2 in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotIn(List<String> values) {
            addCriterion("sO2 not in", values, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2Between(String value1, String value2) {
            addCriterion("sO2 between", value1, value2, "so2");
            return (Criteria) this;
        }

        public Criteria andSo2NotBetween(String value1, String value2) {
            addCriterion("sO2 not between", value1, value2, "so2");
            return (Criteria) this;
        }

        public Criteria andSpdIsNull() {
            addCriterion("sPD is null");
            return (Criteria) this;
        }

        public Criteria andSpdIsNotNull() {
            addCriterion("sPD is not null");
            return (Criteria) this;
        }

        public Criteria andSpdEqualTo(String value) {
            addCriterion("sPD =", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotEqualTo(String value) {
            addCriterion("sPD <>", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdGreaterThan(String value) {
            addCriterion("sPD >", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdGreaterThanOrEqualTo(String value) {
            addCriterion("sPD >=", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLessThan(String value) {
            addCriterion("sPD <", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLessThanOrEqualTo(String value) {
            addCriterion("sPD <=", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLike(String value) {
            addCriterion("sPD like", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotLike(String value) {
            addCriterion("sPD not like", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdIn(List<String> values) {
            addCriterion("sPD in", values, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotIn(List<String> values) {
            addCriterion("sPD not in", values, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdBetween(String value1, String value2) {
            addCriterion("sPD between", value1, value2, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotBetween(String value1, String value2) {
            addCriterion("sPD not between", value1, value2, "spd");
            return (Criteria) this;
        }

        public Criteria andTempIsNull() {
            addCriterion("tEMP is null");
            return (Criteria) this;
        }

        public Criteria andTempIsNotNull() {
            addCriterion("tEMP is not null");
            return (Criteria) this;
        }

        public Criteria andTempEqualTo(String value) {
            addCriterion("tEMP =", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotEqualTo(String value) {
            addCriterion("tEMP <>", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThan(String value) {
            addCriterion("tEMP >", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThanOrEqualTo(String value) {
            addCriterion("tEMP >=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThan(String value) {
            addCriterion("tEMP <", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThanOrEqualTo(String value) {
            addCriterion("tEMP <=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLike(String value) {
            addCriterion("tEMP like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotLike(String value) {
            addCriterion("tEMP not like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempIn(List<String> values) {
            addCriterion("tEMP in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotIn(List<String> values) {
            addCriterion("tEMP not in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempBetween(String value1, String value2) {
            addCriterion("tEMP between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotBetween(String value1, String value2) {
            addCriterion("tEMP not between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTspIsNull() {
            addCriterion("tSP is null");
            return (Criteria) this;
        }

        public Criteria andTspIsNotNull() {
            addCriterion("tSP is not null");
            return (Criteria) this;
        }

        public Criteria andTspEqualTo(String value) {
            addCriterion("tSP =", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspNotEqualTo(String value) {
            addCriterion("tSP <>", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspGreaterThan(String value) {
            addCriterion("tSP >", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspGreaterThanOrEqualTo(String value) {
            addCriterion("tSP >=", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspLessThan(String value) {
            addCriterion("tSP <", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspLessThanOrEqualTo(String value) {
            addCriterion("tSP <=", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspLike(String value) {
            addCriterion("tSP like", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspNotLike(String value) {
            addCriterion("tSP not like", value, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspIn(List<String> values) {
            addCriterion("tSP in", values, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspNotIn(List<String> values) {
            addCriterion("tSP not in", values, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspBetween(String value1, String value2) {
            addCriterion("tSP between", value1, value2, "tsp");
            return (Criteria) this;
        }

        public Criteria andTspNotBetween(String value1, String value2) {
            addCriterion("tSP not between", value1, value2, "tsp");
            return (Criteria) this;
        }

        public Criteria andTvocIsNull() {
            addCriterion("tVOC is null");
            return (Criteria) this;
        }

        public Criteria andTvocIsNotNull() {
            addCriterion("tVOC is not null");
            return (Criteria) this;
        }

        public Criteria andTvocEqualTo(String value) {
            addCriterion("tVOC =", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotEqualTo(String value) {
            addCriterion("tVOC <>", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocGreaterThan(String value) {
            addCriterion("tVOC >", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocGreaterThanOrEqualTo(String value) {
            addCriterion("tVOC >=", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLessThan(String value) {
            addCriterion("tVOC <", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLessThanOrEqualTo(String value) {
            addCriterion("tVOC <=", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLike(String value) {
            addCriterion("tVOC like", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotLike(String value) {
            addCriterion("tVOC not like", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocIn(List<String> values) {
            addCriterion("tVOC in", values, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotIn(List<String> values) {
            addCriterion("tVOC not in", values, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocBetween(String value1, String value2) {
            addCriterion("tVOC between", value1, value2, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotBetween(String value1, String value2) {
            addCriterion("tVOC not between", value1, value2, "tvoc");
            return (Criteria) this;
        }

        public Criteria andWsIsNull() {
            addCriterion("wS is null");
            return (Criteria) this;
        }

        public Criteria andWsIsNotNull() {
            addCriterion("wS is not null");
            return (Criteria) this;
        }

        public Criteria andWsEqualTo(String value) {
            addCriterion("wS =", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsNotEqualTo(String value) {
            addCriterion("wS <>", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsGreaterThan(String value) {
            addCriterion("wS >", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsGreaterThanOrEqualTo(String value) {
            addCriterion("wS >=", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsLessThan(String value) {
            addCriterion("wS <", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsLessThanOrEqualTo(String value) {
            addCriterion("wS <=", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsLike(String value) {
            addCriterion("wS like", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsNotLike(String value) {
            addCriterion("wS not like", value, "ws");
            return (Criteria) this;
        }

        public Criteria andWsIn(List<String> values) {
            addCriterion("wS in", values, "ws");
            return (Criteria) this;
        }

        public Criteria andWsNotIn(List<String> values) {
            addCriterion("wS not in", values, "ws");
            return (Criteria) this;
        }

        public Criteria andWsBetween(String value1, String value2) {
            addCriterion("wS between", value1, value2, "ws");
            return (Criteria) this;
        }

        public Criteria andWsNotBetween(String value1, String value2) {
            addCriterion("wS not between", value1, value2, "ws");
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