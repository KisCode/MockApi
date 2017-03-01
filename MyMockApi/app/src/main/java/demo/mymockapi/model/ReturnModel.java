package demo.mymockapi.model;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class ReturnModel {
    /**
     * Data : {"OnlinePrepareFlightPlanList":[{"Date":"2016-01-26T00:00:00","StartTime":"2016-01-26T17:50:00","EndTime":"2016-01-26T20:05:00","Status":"Done","FlightDynamicList":[{"Id":63071,"FlightType":"正班","PlaneType":"B737","PlaneRegistrationNum":"B5829","FlightNo":"DR6517","DepartureIataCode":"KMG","ArriveIataCode":"KHN","PTD":"2016-01-26T17:50:00","PTA":"2016-01-26T20:05:00"}],"CurrentStepCode":"BaseInfo","PreparationType":"O"},{"Date":"2016-01-27T00:00:00","StartTime":"2016-01-27T23:50:00","EndTime":"2016-01-28T00:55:00","Status":"InProgress","FlightDynamicList":[{"Id":59902,"FlightType":"正班","PlaneType":"B737","PlaneRegistrationNum":"B5811","FlightNo":"DR6510","DepartureIataCode":"JHG","ArriveIataCode":"KMG","PTD":"2016-01-27T23:50:00","PTA":"2016-01-28T00:55:00"}],"CurrentStepCode":"FlightPlan","PreparationType":"O"}],"AircrewPaperInfoList":[{"Id":611,"AircrewKindName":"飞行","AircrewName":"测试飞行","NameShow":"体检合格证","Number":"530103199003454510","PlaneTypeName":"B737","AwardDate":"2016-01-19T00:00:00","InvalidDate":"2017-01-04T00:00:00","Remark":null},{"Id":610,"AircrewKindName":"飞行","AircrewName":"测试飞行","NameShow":"航空安全员执照","Number":"112233","PlaneTypeName":"B737","AwardDate":"2016-01-12T00:00:00","InvalidDate":"2016-02-25T00:00:00","Remark":null}],"WeeklyCrewScheduleList":[],"WeeklyOtherScheduleList":[]}
     * ResultCode : Y
     * Msg : null
     */
    private DataBean Data;
    private String ResultCode;
    private String Msg;

    @Override
    public String toString() {
        return "ReturnModel{" +
                "Data=" + Data +
                ", ResultCode='" + ResultCode + '\'' +
                ", Msg='" + Msg + '\'' +
                '}';
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String ResultCode) {
        this.ResultCode = ResultCode;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public static class DataBean {

        private List<OnlinePrepareFlightPlanListBean> OnlinePrepareFlightPlanList;
        private List<AircrewPaperInfoListBean> AircrewPaperInfoList;
//        private List<?> WeeklyCrewScheduleList;
//        private List<?> WeeklyOtherScheduleList;

        public List<OnlinePrepareFlightPlanListBean> getOnlinePrepareFlightPlanList() {
            return OnlinePrepareFlightPlanList;
        }

        public void setOnlinePrepareFlightPlanList(List<OnlinePrepareFlightPlanListBean> OnlinePrepareFlightPlanList) {
            this.OnlinePrepareFlightPlanList = OnlinePrepareFlightPlanList;
        }

        public List<AircrewPaperInfoListBean> getAircrewPaperInfoList() {
            return AircrewPaperInfoList;
        }

        public void setAircrewPaperInfoList(List<AircrewPaperInfoListBean> AircrewPaperInfoList) {
            this.AircrewPaperInfoList = AircrewPaperInfoList;
        }

//        public List<?> getWeeklyCrewScheduleList() {
//            return WeeklyCrewScheduleList;
//        }
//
//        public void setWeeklyCrewScheduleList(List<?> WeeklyCrewScheduleList) {
//            this.WeeklyCrewScheduleList = WeeklyCrewScheduleList;
//        }
//
//        public List<?> getWeeklyOtherScheduleList() {
//            return WeeklyOtherScheduleList;
//        }
//
//        public void setWeeklyOtherScheduleList(List<?> WeeklyOtherScheduleList) {
//            this.WeeklyOtherScheduleList = WeeklyOtherScheduleList;
//        }

        public static class OnlinePrepareFlightPlanListBean {


            /**
             * Date : 2016-01-26T00:00:00
             * StartTime : 2016-01-26T17:50:00
             * EndTime : 2016-01-26T20:05:00
             * Status : Done
             * FlightDynamicList : [{"Id":63071,"FlightType":"正班","PlaneType":"B737","PlaneRegistrationNum":"B5829","FlightNo":"DR6517","DepartureIataCode":"KMG","ArriveIataCode":"KHN","PTD":"2016-01-26T17:50:00","PTA":"2016-01-26T20:05:00"}]
             * CurrentStepCode : BaseInfo
             * PreparationType : O
             */

            private String Date;
            private String StartTime;
            private String EndTime;
            private String Status;
            private String CurrentStepCode;
            private String PreparationType;
            private List<FlightDynamicListBean> FlightDynamicList;

            public String getDate() {
                return Date;
            }

            public void setDate(String Date) {
                this.Date = Date;
            }

            public String getStartTime() {
                return StartTime;
            }

            public void setStartTime(String StartTime) {
                this.StartTime = StartTime;
            }

            public String getEndTime() {
                return EndTime;
            }

            public void setEndTime(String EndTime) {
                this.EndTime = EndTime;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public String getCurrentStepCode() {
                return CurrentStepCode;
            }

            public void setCurrentStepCode(String CurrentStepCode) {
                this.CurrentStepCode = CurrentStepCode;
            }

            public String getPreparationType() {
                return PreparationType;
            }

            public void setPreparationType(String PreparationType) {
                this.PreparationType = PreparationType;
            }

            public List<FlightDynamicListBean> getFlightDynamicList() {
                return FlightDynamicList;
            }

            public void setFlightDynamicList(List<FlightDynamicListBean> FlightDynamicList) {
                this.FlightDynamicList = FlightDynamicList;
            }

            public static class FlightDynamicListBean {
                @Override
                public String toString() {
                    return "FlightDynamicListBean{" +
                            "Id=" + Id +
                            ", FlightType='" + FlightType + '\'' +
                            ", PlaneType='" + PlaneType + '\'' +
                            ", PlaneRegistrationNum='" + PlaneRegistrationNum + '\'' +
                            ", FlightNo='" + FlightNo + '\'' +
                            ", DepartureIataCode='" + DepartureIataCode + '\'' +
                            ", ArriveIataCode='" + ArriveIataCode + '\'' +
                            ", PTD='" + PTD + '\'' +
                            ", PTA='" + PTA + '\'' +
                            '}';
                }

                /**
                 * Id : 63071
                 * FlightType : 正班
                 * PlaneType : B737
                 * PlaneRegistrationNum : B5829
                 * FlightNo : DR6517
                 * DepartureIataCode : KMG
                 * ArriveIataCode : KHN
                 * PTD : 2016-01-26T17:50:00
                 * PTA : 2016-01-26T20:05:00
                 */

                private int Id;
                private String FlightType;
                private String PlaneType;
                private String PlaneRegistrationNum;
                private String FlightNo;
                private String DepartureIataCode;
                private String ArriveIataCode;
                private String PTD;
                private String PTA;

                public int getId() {
                    return Id;
                }

                public void setId(int Id) {
                    this.Id = Id;
                }

                public String getFlightType() {
                    return FlightType;
                }

                public void setFlightType(String FlightType) {
                    this.FlightType = FlightType;
                }

                public String getPlaneType() {
                    return PlaneType;
                }

                public void setPlaneType(String PlaneType) {
                    this.PlaneType = PlaneType;
                }

                public String getPlaneRegistrationNum() {
                    return PlaneRegistrationNum;
                }

                public void setPlaneRegistrationNum(String PlaneRegistrationNum) {
                    this.PlaneRegistrationNum = PlaneRegistrationNum;
                }

                public String getFlightNo() {
                    return FlightNo;
                }

                public void setFlightNo(String FlightNo) {
                    this.FlightNo = FlightNo;
                }

                public String getDepartureIataCode() {
                    return DepartureIataCode;
                }

                public void setDepartureIataCode(String DepartureIataCode) {
                    this.DepartureIataCode = DepartureIataCode;
                }

                public String getArriveIataCode() {
                    return ArriveIataCode;
                }

                public void setArriveIataCode(String ArriveIataCode) {
                    this.ArriveIataCode = ArriveIataCode;
                }

                public String getPTD() {
                    return PTD;
                }

                public void setPTD(String PTD) {
                    this.PTD = PTD;
                }

                public String getPTA() {
                    return PTA;
                }

                public void setPTA(String PTA) {
                    this.PTA = PTA;
                }
            }

            @Override
            public String toString() {
                return "OnlinePrepareFlightPlanListBean{" +
                        "Date='" + Date + '\'' +
                        ", StartTime='" + StartTime + '\'' +
                        ", EndTime='" + EndTime + '\'' +
                        ", Status='" + Status + '\'' +
                        ", CurrentStepCode='" + CurrentStepCode + '\'' +
                        ", PreparationType='" + PreparationType + '\'' +
                        ", FlightDynamicList=" + FlightDynamicList +
                        '}';
            }
        }

        public static class AircrewPaperInfoListBean {
            @Override
            public String toString() {
                return "AircrewPaperInfoListBean{" +
                        "Id=" + Id +
                        ", AircrewKindName='" + AircrewKindName + '\'' +
                        ", AircrewName='" + AircrewName + '\'' +
                        ", NameShow='" + NameShow + '\'' +
                        ", Number='" + Number + '\'' +
                        ", PlaneTypeName='" + PlaneTypeName + '\'' +
                        ", AwardDate='" + AwardDate + '\'' +
                        ", InvalidDate='" + InvalidDate + '\'' +
                        ", Remark='" + Remark + '\'' +
                        '}';
            }

            /**
             * Id : 611
             * AircrewKindName : 飞行
             * AircrewName : 测试飞行
             * NameShow : 体检合格证
             * Number : 530103199003454510
             * PlaneTypeName : B737
             * AwardDate : 2016-01-19T00:00:00
             * InvalidDate : 2017-01-04T00:00:00
             * Remark : null
             */

            private int Id;
            private String AircrewKindName;
            private String AircrewName;
            private String NameShow;
            private String Number;
            private String PlaneTypeName;
            private String AwardDate;
            private String InvalidDate;
            private String Remark;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getAircrewKindName() {
                return AircrewKindName;
            }

            public void setAircrewKindName(String AircrewKindName) {
                this.AircrewKindName = AircrewKindName;
            }

            public String getAircrewName() {
                return AircrewName;
            }

            public void setAircrewName(String AircrewName) {
                this.AircrewName = AircrewName;
            }

            public String getNameShow() {
                return NameShow;
            }

            public void setNameShow(String NameShow) {
                this.NameShow = NameShow;
            }

            public String getNumber() {
                return Number;
            }

            public void setNumber(String Number) {
                this.Number = Number;
            }

            public String getPlaneTypeName() {
                return PlaneTypeName;
            }

            public void setPlaneTypeName(String PlaneTypeName) {
                this.PlaneTypeName = PlaneTypeName;
            }

            public String getAwardDate() {
                return AwardDate;
            }

            public void setAwardDate(String AwardDate) {
                this.AwardDate = AwardDate;
            }

            public String getInvalidDate() {
                return InvalidDate;
            }

            public void setInvalidDate(String InvalidDate) {
                this.InvalidDate = InvalidDate;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "OnlinePrepareFlightPlanList=" + OnlinePrepareFlightPlanList +
                    ", AircrewPaperInfoList=" + AircrewPaperInfoList +
                    '}';
        }
    }
}
