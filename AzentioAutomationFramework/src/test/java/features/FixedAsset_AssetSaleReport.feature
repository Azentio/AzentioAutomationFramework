Feature: Checking the Fixed Asset Sale Report functionality

@KUBS_FAT_UAT_013_013  @MultiAuth

Scenario: Map the various GLs for created asset code
Given Maker Navigate to UAT URL login
Then click on report segment button
Then Click on Report field
Then click on Asset Sale Report
Then Select the Asset Sale Code
Then Select the date Asset Sale
And click on view button of report
Then verify the Asset Sale report
