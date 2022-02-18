Feature: Shadow dom test
Scenario: Check shadow dom can be fixed
Given navigate to URL and login as a maker and choose finance option
Then click on budget configuration Menu
And click on budget definition sub menu and click on eye icon
Then click on pencil icon near by budget code
And update the budget code shadow
#Then update the budget budget type
#Then update warning percentage
#Then update budget name
#Then update remark
#And click on save after update all the details
#document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText
#Then check alert will came or not
