*** Settings ***
Documentation    Perform Inquiry creation
Library    SeleniumLibrary

*** Variables ***

*** Keywords ***
Click on Prospects icon
    Click Button    xpath://i[@class="nav-prospect"]
    Sleep    10s
Click New Button
    [Arguments]    ${MenuItem}
    Sleep    15s
    ${extractedText}=    Get Text    xpath://h5[contains(text(),"${MenuItem}")]
    Should Be Equal As Strings    ${extractedText}    PROSPECTS
    Click Button    id:newstore
Add Contact Infos
    [Arguments]    ${FirstName}    ${LastName}
    Sleep    10s
    Input Text    xpath://input[@formcontrolname="FirstName"]    ${FirstName}
    Input Text    xpath://input[@formcontrolname="LastName"]    ${LastName}
Click Unit Info tab
    Sleep    10s
    Double Click Element    xpath://a/span[contains(text(),"Unit Info")]
    Sleep    5s
    Double Click Element    xpath://a/span[contains(text(),"Unit Info")]
    
    