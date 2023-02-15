*** Settings ***
Documentation    World of Testing Project 1 Driver setup
Library    SeleniumLibrary

*** Variables ***

${chromeDriver}    C:/Users/anushree/Documents/Robot/chromedriver_win32/chromedriver_win32

    
*** Keywords ***
Get the required Driver
    #Open Browser    ${URL}    browser=${Browser}    
    [Arguments]    ${Browser}    
    Create Webdriver    ${Browser}    executable_path=${chromeDriver}

# Open the Browser
#     Open Browser ${Browser}