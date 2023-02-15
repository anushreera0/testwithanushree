*** Settings ***
Documentation    Perform Inquiry creation
Library    SeleniumLibrary
Library    OperatingSystem
Resource    SelectUnit.robot

*** Variables ***

*** Keywords ***
Verify Dashboard screen
    TRY
        Title Should Be    SSM
        Wait Until Page Contains Element    xpath://h5[contains(text(),'Dashboard')]
        ${extractedText}=    Get Text    xpath://h5[contains(text(),'Dashboard')][1]
        Capture Page Screenshot
        Log    ${extractedText}
        Should Be Equal As Strings    ${extractedText}    DASHBOARD
        Log    Dashboard screen
    EXCEPT    
        Get Title
        Sleep    5s
        Log    Failed to verify Login

    END

Click on Item in Menu
    [Arguments]    ${MenuItem}
    Sleep    10s
    Wait Until Page Contains Element    id:menuContent
    Sleep    15s
    Click Element    xpath://a[@dataname="${MenuItem}"]/i
    Sleep    5s
    # @{getMenuItems}=    Create List 
    # ${Elements}    Get WebElements    xpath://div[@id='menuContent']/a/span
    # Log    ${getMenuItems}
    # FOR    ${element}    IN    ${getMenuItems}
    #     Sleep                7
        
    #     Exit For Loop If    '${element}'=='${MenuItem}'
    # END
            
