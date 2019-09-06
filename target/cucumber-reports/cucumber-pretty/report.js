$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/shipping.feature");
formatter.feature({
  "line": 1,
  "name": "Create shipping",
  "description": "",
  "id": "create-shipping",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Enter originating shippin address",
  "description": "",
  "id": "create-shipping;enter-originating-shippin-address",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a user navigates to create shipping page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters shipping address info",
  "rows": [
    {
      "cells": [
        "FullName",
        "Address",
        "ZipCode",
        "Email",
        "Phone"
      ],
      "line": 7
    },
    {
      "cells": [
        "Tom Peter",
        "123 Home St.",
        "46835",
        "tom@gmail.com",
        "2023334578"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "system autofiles city and state based on zipcode entered",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user clicks on continue button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "system displays address entered with edit option",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "ShippingStepDefinition.a_user_navigates_to_create_shipping_page()"
});
formatter.result({
  "duration": 14182927700,
  "status": "passed"
});
formatter.match({
  "location": "ShippingStepDefinition.user_enters_shipping_address_info(DataTable)"
});
formatter.result({
  "duration": 2457807000,
  "status": "passed"
});
formatter.match({
  "location": "ShippingStepDefinition.system_autofiles_city_and_state_based_on_zipcode_entered()"
});
formatter.result({
  "duration": 3337973800,
  "status": "passed"
});
formatter.match({
  "location": "ShippingStepDefinition.user_clicks_on_continue_button()"
});
formatter.result({
  "duration": 367094700,
  "status": "passed"
});
formatter.match({
  "location": "ShippingStepDefinition.system_displays_address_entered_with_edit_option()"
});
formatter.result({
  "duration": 56149500,
  "status": "passed"
});
formatter.match({
  "location": "ShippingStepDefinition.close_browser()"
});
formatter.result({
  "duration": 934387300,
  "status": "passed"
});
});