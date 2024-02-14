@echo off
set BASE=%~dp0
set APP_NAME=${project.name}-${project.version}
set JAVA_HOME=%BASE%/runtime/bin/java
TITLE %APP_NAME%

%JAVA_HOME% -jar "%BASE%%APP_NAME%.jar" "TRUE" --configDir="%BASE%

:done