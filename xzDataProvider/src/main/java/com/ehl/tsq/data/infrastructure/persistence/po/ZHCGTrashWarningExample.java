package com.ehl.tsq.data.infrastructure.persistence.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZHCGTrashWarningExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZHCGTrashWarningExample() {
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

        public Criteria andTrashSensorIdIsNull() {
            addCriterion("trash_sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdIsNotNull() {
            addCriterion("trash_sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdEqualTo(String value) {
            addCriterion("trash_sensor_id =", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdNotEqualTo(String value) {
            addCriterion("trash_sensor_id <>", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdGreaterThan(String value) {
            addCriterion("trash_sensor_id >", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("trash_sensor_id >=", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdLessThan(String value) {
            addCriterion("trash_sensor_id <", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdLessThanOrEqualTo(String value) {
            addCriterion("trash_sensor_id <=", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdLike(String value) {
            addCriterion("trash_sensor_id like", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdNotLike(String value) {
            addCriterion("trash_sensor_id not like", value, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdIn(List<String> values) {
            addCriterion("trash_sensor_id in", values, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdNotIn(List<String> values) {
            addCriterion("trash_sensor_id not in", values, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdBetween(String value1, String value2) {
            addCriterion("trash_sensor_id between", value1, value2, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andTrashSensorIdNotBetween(String value1, String value2) {
            addCriterion("trash_sensor_id not between", value1, value2, "trashSensorId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCmdIsNull() {
            addCriterion("cmd is null");
            return (Criteria) this;
        }

        public Criteria andCmdIsNotNull() {
            addCriterion("cmd is not null");
            return (Criteria) this;
        }

        public Criteria andCmdEqualTo(String value) {
            addCriterion("cmd =", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotEqualTo(String value) {
            addCriterion("cmd <>", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThan(String value) {
            addCriterion("cmd >", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThanOrEqualTo(String value) {
            addCriterion("cmd >=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThan(String value) {
            addCriterion("cmd <", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThanOrEqualTo(String value) {
            addCriterion("cmd <=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLike(String value) {
            addCriterion("cmd like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotLike(String value) {
            addCriterion("cmd not like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdIn(List<String> values) {
            addCriterion("cmd in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotIn(List<String> values) {
            addCriterion("cmd not in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdBetween(String value1, String value2) {
            addCriterion("cmd between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotBetween(String value1, String value2) {
            addCriterion("cmd not between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andRssiIsNull() {
            addCriterion("rssi is null");
            return (Criteria) this;
        }

        public Criteria andRssiIsNotNull() {
            addCriterion("rssi is not null");
            return (Criteria) this;
        }

        public Criteria andRssiEqualTo(Integer value) {
            addCriterion("rssi =", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiNotEqualTo(Integer value) {
            addCriterion("rssi <>", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiGreaterThan(Integer value) {
            addCriterion("rssi >", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiGreaterThanOrEqualTo(Integer value) {
            addCriterion("rssi >=", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiLessThan(Integer value) {
            addCriterion("rssi <", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiLessThanOrEqualTo(Integer value) {
            addCriterion("rssi <=", value, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiIn(List<Integer> values) {
            addCriterion("rssi in", values, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiNotIn(List<Integer> values) {
            addCriterion("rssi not in", values, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiBetween(Integer value1, Integer value2) {
            addCriterion("rssi between", value1, value2, "rssi");
            return (Criteria) this;
        }

        public Criteria andRssiNotBetween(Integer value1, Integer value2) {
            addCriterion("rssi not between", value1, value2, "rssi");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andPassTimeIsNull() {
            addCriterion("pass_time is null");
            return (Criteria) this;
        }

        public Criteria andPassTimeIsNotNull() {
            addCriterion("pass_time is not null");
            return (Criteria) this;
        }

        public Criteria andPassTimeEqualTo(Integer value) {
            addCriterion("pass_time =", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotEqualTo(Integer value) {
            addCriterion("pass_time <>", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeGreaterThan(Integer value) {
            addCriterion("pass_time >", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_time >=", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeLessThan(Integer value) {
            addCriterion("pass_time <", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeLessThanOrEqualTo(Integer value) {
            addCriterion("pass_time <=", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeIn(List<Integer> values) {
            addCriterion("pass_time in", values, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotIn(List<Integer> values) {
            addCriterion("pass_time not in", values, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeBetween(Integer value1, Integer value2) {
            addCriterion("pass_time between", value1, value2, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_time not between", value1, value2, "passTime");
            return (Criteria) this;
        }

        public Criteria andBattaryIsNull() {
            addCriterion("battary is null");
            return (Criteria) this;
        }

        public Criteria andBattaryIsNotNull() {
            addCriterion("battary is not null");
            return (Criteria) this;
        }

        public Criteria andBattaryEqualTo(Integer value) {
            addCriterion("battary =", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryNotEqualTo(Integer value) {
            addCriterion("battary <>", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryGreaterThan(Integer value) {
            addCriterion("battary >", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("battary >=", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryLessThan(Integer value) {
            addCriterion("battary <", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryLessThanOrEqualTo(Integer value) {
            addCriterion("battary <=", value, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryIn(List<Integer> values) {
            addCriterion("battary in", values, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryNotIn(List<Integer> values) {
            addCriterion("battary not in", values, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryBetween(Integer value1, Integer value2) {
            addCriterion("battary between", value1, value2, "battary");
            return (Criteria) this;
        }

        public Criteria andBattaryNotBetween(Integer value1, Integer value2) {
            addCriterion("battary not between", value1, value2, "battary");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(Integer value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Integer value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Integer value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Integer value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Integer> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Integer> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andFullIsNull() {
            addCriterion("full is null");
            return (Criteria) this;
        }

        public Criteria andFullIsNotNull() {
            addCriterion("full is not null");
            return (Criteria) this;
        }

        public Criteria andFullEqualTo(Integer value) {
            addCriterion("full =", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotEqualTo(Integer value) {
            addCriterion("full <>", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullGreaterThan(Integer value) {
            addCriterion("full >", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullGreaterThanOrEqualTo(Integer value) {
            addCriterion("full >=", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullLessThan(Integer value) {
            addCriterion("full <", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullLessThanOrEqualTo(Integer value) {
            addCriterion("full <=", value, "full");
            return (Criteria) this;
        }

        public Criteria andFullIn(List<Integer> values) {
            addCriterion("full in", values, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotIn(List<Integer> values) {
            addCriterion("full not in", values, "full");
            return (Criteria) this;
        }

        public Criteria andFullBetween(Integer value1, Integer value2) {
            addCriterion("full between", value1, value2, "full");
            return (Criteria) this;
        }

        public Criteria andFullNotBetween(Integer value1, Integer value2) {
            addCriterion("full not between", value1, value2, "full");
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