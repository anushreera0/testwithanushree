*** Settings ***
Documentation    World of Testing Project 1 Login to Application
Library    SeleniumLibrary

*** Keywords ***
Launch the URL
    [Arguments]    ${URL}
    Go To    ${URL}
    Maximize Browser Window
    Sleep    10s
    Title Should Be    Login
Enter Username
    [Arguments]   ${Username} 
    Input Text    id:signInName    ${Username}
Enter Password
    [Arguments]    ${Password}
    Input Password    id:password    ${Password}
Click on Submit button
    Click Button    id:next
    Sleep    15s