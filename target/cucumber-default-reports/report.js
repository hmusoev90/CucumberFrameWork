$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/createEmployeesAPI.feature");
formatter.feature({
  "name": "Creating Employees",
  "description": "  Description: This feature creates employees",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@CreateEmployees"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.step({
  "name": "employee data provided is \"\u003cemployeeFirstName\u003e\", \"\u003cemployeeLastName\u003e\", \"\u003cemployeeMiddleName\u003e\",\"\u003cemployeeGender\u003e\",\"\u003cemployeeBirthday\u003e\",\"\u003cemployeeJobStatus\u003e\",\"\u003cemployeeJobTitle\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "employeeFirstName",
        "employeeLastName",
        "employeeMiddleName",
        "employeeGender",
        "employeeBirthday",
        "employeeJobStatus",
        "employeeJobTitle"
      ]
    },
    {
      "cells": [
        "Bob",
        "Bob",
        "Bob",
        "M",
        "2000-07-11",
        "Employee",
        "Cloud Architect"
      ]
    },
    {
      "cells": [
        "Gozde",
        "Gozde",
        "Gozde",
        "F",
        "2000-07-11",
        "Independent contractor",
        "API Tester"
      ]
    },
    {
      "cells": [
        "Irma",
        "Irma",
        "Irma",
        "F",
        "2000-07-11",
        "Super Contractor",
        "CEO"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CreateEmployees"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Bob\", \"Bob\", \"Bob\",\"M\",\"2000-07-11\",\"Employee\",\"Cloud Architect\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: Header value cannot be null\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)\r\n\tat io.restassured.internal.common.assertion.AssertParameter.notNull(AssertParameter.groovy:26)\r\n\tat io.restassured.internal.common.assertion.AssertParameter$notNull.callStatic(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallStatic(CallSiteArray.java:55)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callStatic(AbstractCallSite.java:217)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callStatic(AbstractCallSite.java:240)\r\n\tat io.restassured.internal.RequestSpecificationImpl.header(RequestSpecificationImpl.groovy:843)\r\n\tat com.hrms.utils.APICommonMethods.createEmployeeRequest(APICommonMethods.java:59)\r\n\tat com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(createEmployeesAPI.java:24)\r\n\tat ✽.employee data provided is \"Bob\", \"Bob\", \"Bob\",\"M\",\"2000-07-11\",\"Employee\",\"Cloud Architect\"(file:///C:/Users/Habib/eclipse-workspace/05CucumberFrameWork/src/test/resources/features/createEmployeesAPI.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employees_are_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CreateEmployees"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Gozde\", \"Gozde\", \"Gozde\",\"F\",\"2000-07-11\",\"Independent contractor\",\"API Tester\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: Header value cannot be null\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)\r\n\tat io.restassured.internal.common.assertion.AssertParameter.notNull(AssertParameter.groovy:26)\r\n\tat io.restassured.internal.common.assertion.AssertParameter$notNull.callStatic(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl.header(RequestSpecificationImpl.groovy:843)\r\n\tat com.hrms.utils.APICommonMethods.createEmployeeRequest(APICommonMethods.java:59)\r\n\tat com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(createEmployeesAPI.java:24)\r\n\tat ✽.employee data provided is \"Gozde\", \"Gozde\", \"Gozde\",\"F\",\"2000-07-11\",\"Independent contractor\",\"API Tester\"(file:///C:/Users/Habib/eclipse-workspace/05CucumberFrameWork/src/test/resources/features/createEmployeesAPI.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employees_are_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CreateEmployees"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Irma\", \"Irma\", \"Irma\",\"F\",\"2000-07-11\",\"Super Contractor\",\"CEO\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: Header value cannot be null\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)\r\n\tat io.restassured.internal.common.assertion.AssertParameter.notNull(AssertParameter.groovy:26)\r\n\tat io.restassured.internal.common.assertion.AssertParameter$notNull.callStatic(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl.header(RequestSpecificationImpl.groovy:843)\r\n\tat com.hrms.utils.APICommonMethods.createEmployeeRequest(APICommonMethods.java:59)\r\n\tat com.hrms.API.steps.createEmployeesAPI.employee_data_provided_is(createEmployeesAPI.java:24)\r\n\tat ✽.employee data provided is \"Irma\", \"Irma\", \"Irma\",\"F\",\"2000-07-11\",\"Super Contractor\",\"CEO\"(file:///C:/Users/Habib/eclipse-workspace/05CucumberFrameWork/src/test/resources/features/createEmployeesAPI.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.steps.createEmployeesAPI.employees_are_created()"
});
formatter.result({
  "status": "skipped"
});
});