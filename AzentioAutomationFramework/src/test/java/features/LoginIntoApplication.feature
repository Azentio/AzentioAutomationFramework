Feature: Application Login

Background:
Given Open any Browser
@login
Scenario: Login with valid credentials
And Navigate to Login page
When User enters usernamea and password in their respective fields
And User clicks on Login button
Then Verify user is able to successfully login

