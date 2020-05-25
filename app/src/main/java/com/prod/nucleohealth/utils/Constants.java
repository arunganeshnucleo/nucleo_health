package com.prod.nucleohealth.utils;

public class Constants{
        public static String BASE_PHP_URL_DEV =  "https://sui3g7464b.execute-api.us-east-1.amazonaws.com/dev/api/";
        public static String BASE_PHP_URL_PRODUCTION=  "https://sui3g7464b.execute-api.us-east-1.amazonaws.com/dev/api/";
        public static String APPLICATION_ID = "c86ae3f5-3a96-49f2-af05-94746357d0ec";
        public static String ACCEPT_HEADER = "application/json";
        public static String CONTENT_TYPE = "application/json";
        public static String PATIENT = "patient";
        public static String DOCTOR = "doctor";

        public static String STATUS_SUCCESS = "1";
        public static String STATUS_ERROR = "0";
        public static  enum LoginType {
                Normal {
                        @Override
                        public String toString() {
                                return "Normal";
                        }
                },
                FaceBook {
                        @Override
                        public String toString() {
                                return "FaceBook";
                        }
                },
                Google {
                        @Override
                        public String toString() {
                                return "Google";
                        }
                }

        }

        public static  enum UserType {
                Doctor {
                        @Override
                        public String toString() {
                                return "doctor";
                        }
                },
                Patient {
                        @Override
                        public String toString() {
                                return "patient";
                        }
                }

        }

}
