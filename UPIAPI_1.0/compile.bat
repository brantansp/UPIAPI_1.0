set projectLocation=C:\Users\brantansp\Desktop\MobileBanking
cd %projectLocation%
@Java -cp C:\Users\brantansp\Desktop\MobileBanking\lib\*;bin; org.testng.TestNG testng.xml
pause