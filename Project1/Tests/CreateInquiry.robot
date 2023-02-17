*** Settings ***
Documentation    Perform Inquiry creation
Library    SeleniumLibrary
#Test Teardown    Close Browser
Resource    ../Resources/setupDriver.robot
Resource    ../Resources/testLogin.robot
Resource    ../Resources/DashboardScreen.robot
Resource    ../Resources/InquiryScreen.robot
Resource    ../Resources/ProspectsScreen.robot
Resource    ../Resources/UnitInfoscreen.robot
Resource    ../Resources/TransactionSuccessFailure.robot

*** Variables ***
${Username}       ez Manager
${Password}       Esoft@555
${URL}            https://stg.ssm-erp.com
${Browser}        Chrome
${MenuItem}       Prospects
${Store}    TestP0045 Public Storage Canadian Properties
${UnitSize}    0.10X0.11

*** Test Cases ***
Create Inquiry    
    Login to application
    Verify the Dashboard screen
    Select Prospects
    Add Contact Info 
    Select unit
    Click on Inquiry button
    Verify Inquiry screen
    Add Notes
    Click Create Inquiry button
    # Verify Transaction Success
    # Verify Unit Info screen after Inquiry creation

# Create Inquiry with Follow Up
    
*** Keywords ***
Login to application
    Get the required Driver    ${Browser}
    Launch the URL    ${URL}
    Enter Username    ${Username}
    Enter Password    ${Password}
    Click on Submit button

Verify the Dashboard screen
    Verify Dashboard screen
Select Prospects
    Click on Item in Menu    ${MenuItem}
    Click New Button    ${MenuItem}
Add Contact Info    
    
    ${FirstName}=    Generate Random String    5-10
    ${FirstName}=    Catenate    Inq    ${FirstName}

    ${LastName}=    Generate Random String    3-4
    Add Contact Infos    ${FirstName}    ${LastName}
Select unit
    Click Unit Info tab
    Click Add Unit icon
    Select Date
    Select Store    ${Store}
    Select unit type in Add Unit popup    ${UnitSize}
    Select Unit in Add Unit popup
    Click Select button
Click on Inquiry button
    Click Inquiry button
Verify Inquiry screen
    Verification of Inquiry screen
Add Notes
    Add Notes in Prospects
Click Create Inquiry button
    Click Create Inquiry Button
# Verify Transaction Success
    
# Verify Unit Info screen after Inquiry creation


    
