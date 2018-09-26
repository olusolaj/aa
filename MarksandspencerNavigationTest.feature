Feature: Marksandspencer.com 
description: This test is to test the NAVIGATION FUNCTIONALITY of this site

Scenario: Successful Navigation
Given User is on Home Page 
When Search and select first Item 
Then Add first item to the baskest 
When Search and select second Item 
Then Add second item to the baskest
When Search and select third Item 
Then Add third item to the baskest
Then Navigate to checkout the items
But Verify the total price with the expected price
And Display a successful message