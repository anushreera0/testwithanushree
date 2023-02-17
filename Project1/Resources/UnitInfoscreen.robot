*** Settings ***
Documentation    Perform Inquiry creation
Library    SeleniumLibrary
Library    String
Library    XML

*** Variables ***

*** Keywords ***
Click Add Unit icon
    Wait Until Element Is Visible    xpath://a[@id="openModalButton"]/img    20s
    Click Image    xpath://a[@id="openModalButton"]/img
    Sleep    10s
    Capture Page Screenshot
    ${extracted}=    Get Text    xpath://div[contains(@class,'modal-header')]/h5[contains(text(),'Add Unit')]
    Sleep    10s
    Should Be Equal As Strings    ${extracted}    Add Unit

Select Date
    ${Date}=    Get Text    xpath://input[@id="ej2-datepicker_20_input"]
Select Store
    [Arguments]    ${Store}
    @{Stores}=    Get WebElements    xpath://*[@id='AddUnitModal']/div/div/div[2]/div[1]/div[4]/select
    FOR    ${element}    IN    @{Stores}
        Log    ${element.text}
        
    END    
    Select From List By Label    xpath://*[@id='AddUnitModal']/div/div/div[2]/div[1]/div[4]/select    ${Store}

Select unit type in Add Unit popup
    [Arguments]    ${UnitSize}
    # Wait Until Element Is Visible    xpath://div[@class="unit_sel_box"]/select[contains(@class,"form-control ng-pristine ng-valid ng-touched")]    10s
    # Select From List By Value    xpath://select[contains(@class,"form-control ng-pristine ng-valid ng-touched")]    ${UnitSize}
    Select From List By Value    xpath://div[@class=\"unit_sel_box\"]/select    ${UnitSize}
    Wait Until Element Is Visible    xpath://td[contains(text(),"${UnitSize}")]    10s
    Click Link    xpath://td[contains(text(),"${UnitSize}")]/parent::tr/td/a

Select Unit in Add Unit popup
    Sleep    10s
    # Wait Until Element Is Visible    xpath:(//tr/td/div/label)[1]    15s
    Click Element   xpath:(//tr/td/div/label)[1]
    ${UnitNumber}=    Get Text    xpath:((//input[contains(@class,"ng-untouched ng-pristine ng-valid")]/following-sibling::span)[1]/following::td)[1]
Click Select button
    Click Button    id:selectcardview

Click Inquiry button
    Wait Until Page Contains Element    xpath://button[contains(text(),"Inquiry")]    20s
    Click Button    xpath://button[contains(text(),"Inquiry")]
    