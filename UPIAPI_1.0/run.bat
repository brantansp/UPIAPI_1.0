@Title Mobile Banking API automation 4.0 %Date% %Time%
@set projloc=%~dp0
@cd %projloc%
@set classpath=%projloc%\lib\*;%projloc%\target\classes;%projloc%\target\test-classes
@java -Dlog4j.configuration=file:%projloc%\property\log4j.properties org.testng.TestNG testng.xml
@pause