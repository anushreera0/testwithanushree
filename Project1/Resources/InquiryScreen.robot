*** Settings ***
Documentation    Perform Inquiry creation
Library    SeleniumLibrary

*** Variables ***

*** Keywords ***
Verification of Inquiry screen
    Wait Until Element Is Not Visible    xpath://img[@alt="Loader"]    20s
    Scroll Element Into View    xpath://h5[contains(text(),"Inquiry Unit")]
    Page Should Contain    INQUIRY UNIT    20s

Add Notes in Prospects
    Wait Until Page Contains Element    xpath://li/a[contains(@class,"ng-star-inserted")][text()="Notes"]    20s
    Click Element    xpath://li/a[contains(@class,"ng-star-inserted")][text()="Notes"]
    Wait Until Page Contains    NOTES
    Page Should Contain Element    xpath://h5[contains(text(),"Notes")]
    Input Text    xpath://textarea/preceding::label[contains(text(),"Internal Note")]    Internal Notes Added
    Input Text    xpath://textarea/preceding::label[contains(text(),"Customer Note")]    Customer Notes Addeed
    Wait Until Element Is Enabled    xpath://button[contains(text(),"Save")]
    Click button    xpath://button[contains(text(),"Save")]
Add Follow Up
    
Click Create Inquiry Button
    Wait Until Page Contains Element    xpath://*[contains(text(),"Save Inquiry")]    20s
    Wait Until Element Is Enabled    xpath://button[contains(text(),"Save Inquiry")]    15s
    Click Button    xpath://*[contains(text(),"Save Inquiry")]