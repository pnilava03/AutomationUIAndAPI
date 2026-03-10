Properties file configuration needed to run this Application

C:.
│   .gitignore
│   Jenkinsfile
│   pom.xml
│   README.md
│   
├───.idea
│   │   compiler.xml
│   │   easycode.ignore
│   │   encodings.xml
│   │   jarRepositories.xml
│   │   misc.xml
│   │   vcs.xml
│   │   workspace.xml
│   │   
│   └───easycode
│           codebase-v2.xml
│           
├───.mvn
├───logs
│       opencart.log
│       
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───qa
│   │   │           └───opencart
│   │   │               ├───constants
│   │   │               │       AppConstant.java
│   │   │               │       
│   │   │               ├───driverManager
│   │   │               │       DriverFactory.java
│   │   │               │       OptionManager.java
│   │   │               │       
│   │   │               ├───enums
│   │   │               │       EnvironmentType.java
│   │   │               │       PriorityType.java
│   │   │               │       
│   │   │               ├───exceptions
│   │   │               │       EnvironmentException.java
│   │   │               │       NoHeaderFoundExceptions.java
│   │   │               │       
│   │   │               └───utils
│   │   │                       APISpecifications.java
│   │   │                       ElementUtil.java
│   │   │                       JavaScriptUtil.java
│   │   │                       PropertiesFile.java
│   │   │                       ReportsUtil.java
│   │   │                       
│   │   └───resources
│   └───test
│       ├───java
│       │   └───com
│       │       └───qa
│       │           └───opencart
│       │               ├───Analyzer
│       │               │       RetryAnalyzer.java
│       │               │       
│       │               ├───APIRequests
│       │               │       CreateIssueRequest.java
│       │               │       IssueComment.java
│       │               │       UpdateComments.java
│       │               │       
│       │               ├───base
│       │               │       BaseTest.java
│       │               │       Hooks.java
│       │               │       
│       │               ├───Builder
│       │               │       JiraPayLoadBuilder.java
│       │               │       
│       │               ├───JIRAAPI
│       │               │       CreateIssue.java
│       │               │       
│       │               ├───log
│       │               │       TestLogger.java
│       │               │       
│       │               ├───pages
│       │               │       AccountPage.java
│       │               │       LoginPage.java
│       │               │       
│       │               ├───POJO
│       │               │       Assignee.java
│       │               │       Body.java
│       │               │       ContentBlock.java
│       │               │       Description.java
│       │               │       Fields.java
│       │               │       Issuetype.java
│       │               │       Priority.java
│       │               │       Project.java
│       │               │       TextNode.java
│       │               │       Visibility.java
│       │               │       
│       │               ├───Runner
│       │               │       TestRunner.java
│       │               │       TestRunnerNegative.java
│       │               │       TestRunnerSmoke.java
│       │               │       
│       │               ├───stepsDefinition
│       │               │       AccountPageStep.java
│       │               │       LoginStep.java
│       │               │       
│       │               ├───Testing
│       │               │       APITesting.java
│       │               │       LoginPage.java
│       │               │       Testing.java
│       │               │       Utils.java
│       │               │       
│       │               └───tests
│       │                       AccountTest.java
│       │                       LoginTests.java
│       │                       
│       └───resources
│           │   chaintest.properties
│           │   configFile.properties
│           │   log4j2.properties
│           │   log4j2.xml
│           │   
│           ├───features
│           │       AccountPage.feature
│           │       LoginPage.feature
│           │       
│           └───xmlFiles
│                   negative.xml
│                   smoke.xml
│                   testNG.xml
│                   
└───target
│   cucumber-report.html
│   
├───chaintest
│   │   Email.html
│   │   Index.html
│   │   
│   └───resources
│           021ae9f4-2aae-45c4-82e2-e3c023743a03.png
│           04b3cb39-8434-4850-8799-81dec9264478.png
│           0d114aea-3359-4c01-9371-ff2e5a903b78.png
│           0e334973-2d71-49f7-958a-1c2da6841534.png
│           10fa8fed-343f-470d-99d7-9ecfc50f9977.png
│           1318bf01-cf36-48a0-8d50-dfd79026b7a0.png
│           13895ff3-3563-43c7-95e1-316800e93d56.png
│           167e53f2-935f-4ffc-b8bb-b4900261917e.png
│           168e39e0-809c-4b6f-a393-004bf924e836.png
│           1cbd93a4-c697-47cc-aa95-61d63e3e3c5c.png
│           23b99204-5499-45b7-91b8-cfa3bc72ef97.png
│           23ece901-f2e4-45aa-b9b3-0083e44851c8.png
│           28aeffd5-a6fb-426f-a2ff-16fdefabe56a.png
│           3166248a-4afb-4048-9c7a-1231d0d1a0d1.png
│           34da581d-bffc-4adb-bc1e-672ed270871c.png
│           370f0249-f3b9-4d5b-91a3-cea62aa7b1d6.png
│           37f5ff35-aaef-46c1-9441-e27d00c4a8c3.png
│           38eab3c9-ef94-440f-ae55-69f6ab594101.png
│           431940d4-db69-46db-92b7-95b0d1a59b3e.png
│           47ca0737-67bb-48ac-8251-1681c7a2d123.png
│           49de8ffc-01b0-46a8-8ab2-adfc4d971387.png
│           4aa4cd18-4e86-4261-9ea1-c68d530f5785.png
│           4cd9b365-351b-4611-94a7-1da8bb7c8ece.png
│           4e657d35-755a-49b1-b5f1-04fafefe0c3f.png
│           5267474e-f353-4fd7-859e-8b4efc57f6d6.png
│           52ed319f-d824-4fcb-93b9-e0874e954a11.png
│           53b742c1-78c2-406f-8b88-e46e1fb2e7ba.png
│           58599996-421d-4dff-9891-1adc7a71fb6c.png
│           683d8b47-d182-43cf-9690-3d4e55bf8b08.png
│           6867f28d-6383-41d0-bb94-3267a5c0cf16.png
│           6a2bcb4b-0c61-42ab-b7f9-8d2a58f206e4.png
│           6c477fd0-5ee1-469d-90c5-ab588beca7a5.png
│           6c694940-565e-4587-8ef6-13d93ec5f8f3.png
│           6f12084c-4337-48c1-8a26-a6f3fae441a3.png
│           70db6e2d-23a9-4ab8-97f0-27e1c00a7c08.png
│           72ce11d5-5df4-4b80-8a24-d4595d4dceb5.png
│           739e8512-d56a-4789-b2b9-091b9b728b7d.png
│           75e5da15-9cb0-4973-b62d-4c453494d8bc.png
│           7a87af57-fab1-467a-b38d-86c323a85a3c.png
│           7c914d4a-b6b9-4eaa-9a11-d854fa16a3af.png
│           7dc2a458-6afe-4d48-8ed8-83c313205b74.png
│           814f922d-562e-45d9-9122-6ee50da63251.png
│           8204b9a6-3bd1-4a1a-9f3c-a9dfb7f7fe33.png
│           823d0a55-9fc6-43ae-8f5a-04a83f007f5b.png
│           8681351f-b40e-4cf3-bd56-d88cff46ba61.png
│           87bbd3b2-2d5b-44f7-aba4-300098ade690.png
│           8bdfe3c4-863b-4c17-a4fb-7d34ad22e7bc.png
│           8d8ae3fc-9721-40f8-acbf-8affb90f47b5.png
│           8fc0b078-fa23-44f1-9132-83e243619020.png
│           921b1c27-deac-46c5-9662-b5e9da66a1db.png
│           99e74819-0fd0-489d-9320-6b87fa2580b4.png
│           9ac27f21-a583-45a4-ad7d-2f7cfb9711ae.png
│           ab2dd57a-ec9b-432f-9d3b-8c7f7c12af65.png
│           b0433229-7256-4b72-b43a-d3ca2cd19957.png
│           b1fa090b-66ec-4120-8aef-42e5c4281a59.png
│           b453d335-2855-4a78-b02f-d1fa34b9c227.png
│           bb3623e4-3331-4b5b-8d02-7a0604074355.png
│           bb4e397e-a22c-4b85-8454-6b10fa5a8f67.png
│           bf10bde3-583d-4f20-b7f9-2c54accb7d91.png
│           c13964b5-e7ab-4043-93db-e5f6713324eb.png
│           c75d02ad-bb75-42d0-aff1-7fbe677f3101.png
│           ca45ed33-eeae-45fa-88f1-67e588dcc090.png
│           cc6cf430-c00b-4e79-b4e1-be7a04d93a23.png
│           ccba5137-1b54-4d32-8dd7-d31a5317d996.png
│           ce0853d8-88e2-4e44-8c51-b0dcc6a4e595.png
│           ce3a6b9e-4335-45f3-bccb-365abbe5216b.png
│           d15490c4-eb0b-4daf-9068-a1fee4b9ee56.png
│           d5a1acdf-0427-44e3-8ba5-00bc30201301.png
│           d9fd21ce-11ec-478f-a5ec-4002f18bacec.png
│           de1cedfd-353f-4fe0-a9e4-a59b078b4557.png
│           df1fd546-ec45-4e32-a2ba-dace708420a5.png
│           e1cf4b24-4834-478e-bda1-3f3e81aad522.png
│           e5e57172-9c59-48ba-aa7e-32f7b042db02.png
│           eab842e8-097b-49ed-918c-650d9c32e020.png
│           eb4d4580-3134-4429-8b94-ba500f319c3c.png
│           ed7fbadb-02c5-45f0-8cfe-4343b1552787.png
│           f25dbf43-9841-4a70-8444-830f24355619.png
│           f4ea4099-a594-4263-8e00-adfe9708be29.png
│           fa19bdf4-8c7b-48b5-8ccf-a5ae1add675e.png
│           fafca915-d070-48be-9f4d-84aa89148207.png
│           
├───classes
│   ├───com
│   │   └───qa
│   │       └───opencart
│   │           ├───constants
│   │           │       AppConstant.class
│   │           │       
│   │           ├───driverManager
│   │           │       DriverFactory.class
│   │           │       OptionManager.class
│   │           │       
│   │           ├───enums
│   │           │       EnvironmentType.class
│   │           │       PriorityType.class
│   │           │       
│   │           ├───exceptions
│   │           │       EnvironmentException.class
│   │           │       NoHeaderFoundExceptions.class
│   │           │       
│   │           └───utils
│   │                   APISpecifications.class
│   │                   ElementUtil.class
│   │                   JavaScriptUtil.class
│   │                   PropertiesFile.class
│   │                   ReportsUtil.class
│   │                   
│   └───schemaValidator
│           createIssue_jsonSchema.json
│           getBook_jsonSchema.json
│           
├───generated-sources
│   └───annotations
├───generated-test-sources
│   └───test-annotations
├───maven-status
│   └───maven-compiler-plugin
│       ├───compile
│       │   └───default-compile
│       │           createdFiles.lst
│       │           inputFiles.lst
│       │           
│       └───testCompile
│           └───default-testCompile
│                   createdFiles.lst
│                   inputFiles.lst
│                   
├───screenshot
│       accountLogin.png
│       password.png
│       userName.png
│       
├───screenshots
│       accountLogin.png
│       
├───surefire-reports
│   │   bullet_point.png
│   │   collapseall.gif
│   │   emailable-report.html
│   │   failed.png
│   │   index.html
│   │   jquery-3.6.0.min.js
│   │   navigator-bullet.png
│   │   passed.png
│   │   skipped.png
│   │   TEST-TestSuite.xml
│   │   testng-failed.xml
│   │   testng-reports.css
│   │   testng-reports.js
│   │   testng-reports1.css
│   │   testng-reports2.js
│   │   testng-results.xml
│   │   TestSuite.txt
│   │   
│   ├───junitreports
│   │       TEST-com.qa.opencart.Runner.TestRunner.xml
│   │       
│   └───Opencart App Test Regression Suite
│           Login Page Test_Chrome.html
│           Login Page Test_Chrome.xml
│           testng-failed.xml
│           
└───test-classes
│   chaintest.properties
│   configFile.properties
│   log4j2.properties
│   log4j2.xml
│   
├───com
│   └───qa
│       └───opencart
│           ├───Analyzer
│           │       RetryAnalyzer.class
│           │       
│           ├───APIRequests
│           │       CreateIssueRequest.class
│           │       IssueComment.class
│           │       UpdateComments.class
│           │       
│           ├───base
│           │       BaseTest.class
│           │       Hooks.class
│           │       
│           ├───Builder
│           │       JiraPayLoadBuilder.class
│           │       
│           ├───JIRAAPI
│           │       CreateIssue.class
│           │       
│           ├───log
│           │       TestLogger.class
│           │       
│           ├───pages
│           │       AccountPage.class
│           │       LoginPage.class
│           │       
│           ├───POJO
│           │       Assignee.class
│           │       Body.class
│           │       ContentBlock.class
│           │       Description.class
│           │       Fields.class
│           │       Issuetype.class
│           │       Priority.class
│           │       Project.class
│           │       TextNode.class
│           │       Visibility.class
│           │       
│           ├───Runner
│           │       TestRunner.class
│           │       TestRunnerNegative.class
│           │       TestRunnerSmoke.class
│           │       
│           ├───stepsDefinition
│           │       AccountPageStep.class
│           │       LoginStep.class
│           │       
│           ├───Testing
│           │       APITesting.class
│           │       LoginPage.class
│           │       Testing.class
│           │       Utils.class
│           │       
│           └───tests
│                   AccountTest.class
│                   LoginTests.class
│                   
├───features
│       AccountPage.feature
│       LoginPage.feature
│       
└───xmlFiles
negative.xml
smoke.xml
testNG.xml