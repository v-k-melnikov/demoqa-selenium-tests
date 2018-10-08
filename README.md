
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h1>Test suite for the registration form</h1>

<h2>1. IDEA</h2>

<p>This test suite verifies functions of registration form.</p>


<h2>2. TESTS' PRIORITY</h2>

<p>Test cases presented in order according to their <u>severity</u> from high to low. The highest severity belongs
    to the tests which verifies main function of registration form - <u> to save user's data</u>.
    Severity of other test cases depends on their frequency to happen while using registration form. The automated
    tests cases were chosen for automation, because of their severity
    and also because of their <u>time-consuming</u> in contrast to other test cases.</p>

<h2>3. GLOBAL SETUP and ADDITIONAL INFO</h2>

<p>The next table defines which fields are required for a registration and values' requirements for them. Values ​​that
    meet the specified requirements
    are considered <u>valid</u>. </p>
<table>
    <tr>
        <td>Field's name</td>
        <td>Required</td>
        <td>Requirements for values</td>
    </tr>
    <tr>
        <td>First name</td>
        <td>Yes</td>
        <td>1-64 letters</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>Yes</td>
        <td>1-64 letters</td>
    </tr>
    <tr>
        <td>Hobby</td>
        <td>No</td>
        <td>One or several selected options</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>Yes</td>
        <td>10 or more digits. Can start with '+'</td>
    </tr>
    <tr>
        <td>Username</td>
        <td>Yes</td>
        <td>1-64 characters</td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td>Yes</td>
        <td>1-64 characters. Must contains '@' inside and dot further</td>
    </tr>
    <tr>
        <td>Your profile picture</td>
        <td>No</td>
        <td>Type of file must be png or jpg</td>
    </tr>
    <tr>
        <td>About yourself</td>
        <td>No</td>
        <td>0-256 characters</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>Yes</td>
        <td>8-64 characters. Value must includes 1 low case and 1 upper case letter and 1 digit</td>
    </tr>
    <tr>
        <td>Confirm password</td>
        <td>Yes</td>
        <td>8-64 characters. Value must includes 1 low case and 1 upper case letter and 1 digit</td>
    </tr>
</table>
<h2>4. TEST CASES</h2>

<h4>Before all tests navigate to <a href="http://demoqa.com/registration/">http://demoqa.com/registration/</a></h4>


<h3>Test case TMTJ001. Registration with valid fields.</h3>

<p> Steps:</p>

<p>1. Fill fields email and username with new unique valid values.
<p>2. Fill other required fields with valid values</p>
<p>3. Click on submit.</p>
<p> Expected results</p>
<p>1. Server saved the introduced data.</p>
<p>2. There was displayed a message on top of the form "Thanks for your registration".</p>

<h3>Test case TMTJ002. Submitting the form with maximum and minimum number of characters.</h3>
<h4> Scenario 1. Testing minimum number of characters accepted for each field and first cases for fields "Hobby", "Phone
    Number" and "Your Profile Picture".</h4>
<p> Steps:</p>
<p>1. Fill fields and choose options for them according to the next table.</p>
<table>
    <tr>
        <td><b>Field's name</b></td>
        <td><b>Input value</b></td>
    </tr>
    <tr>
        <td>First name</td>
        <td>"a"</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>"a"</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>"89888888888"</td>
    </tr>
    <tr>
        <td>Username</td>
        <td>"a"</td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td>"a@a.com"</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>"QWErty12"</td>
    </tr>
    <tr>
        <td>Confirm password</td>
        <td>"QWErty12"</td>
    </tr>
</table>
<p>2. Click on submit.</p>
<p> Expected results</p>
<p>1. There wasn't displayed messages near the fields about incorrect input.</p>
<p>2. There was displayed a message about existing email and username.</p>

<h4> Scenario 2. Testing maximum number of characters accepted for each field and second cases for fields "Hobby",
    "Phone Number" and "Your Profile Picture".</h4>
<p> Steps:</p>

<p>1. Fill fields and choose their options according to the next table.</p>
<table>
    <tr>
        <td><b>Field's name</b></td>
        <td><b>Input value</b></td>
    </tr>
    <tr>
        <td>First name</td>
        <td>64 letters</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>64 letters</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>"+79888888888"</td>
    </tr>
    <tr>
        <td>Username</td>
        <td>64 characters</td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td>64 characters incl @ and dot</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>64 characters incl 1 low case, 1 upper case letter and 1 digit</td>
    </tr>
    <tr>
        <td>Confirm password</td>
        <td>The same value like in the "Password" field</td>
    </tr>
</table>
<p>2. Click on "Submit" button.</p>

<p> Expected results</p>

<p>1. There wasn't displayed messages near the fields about incorrect input.</p>
<p>2. There was displayed a message about existing email and username.</p>

<h3>Test case TMTJ003. Leaving a required fields blank.</h3>

<p> Steps:</p>

<p>1. Fill fields and choose their options according to the next table.</p>


<table>
    <tr>
        <td><b>Input value</b></td>
        <td><b>Expected results</b></td>
    </tr>
    <tr>
        <td>"First name" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "First name" and "Last name"</td>
    </tr>
    <tr>
        <td>"Last name" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "First name" and "Last name"</td>
    </tr>
    <tr>
        <td>"Phone Number" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "Phone number"</td>
    </tr>
    <tr>
        <td>"Username" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "Username"</td>
    </tr>
    <tr>
        <td>"E-mail" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "E-mail"</td>
    </tr>
    <tr>
        <td>"Password" = blank, other required fields valid</td>
        <td>Error message "This field is required" should be displayed around "Password"</td>
    </tr>
</table>


<h3> Test case TMTJ004. Exceeding maximum lengths of field input .</h3>

<p> Steps:</p>

<p>1. Fill fields and choose their options according to the next table.</p>
<table>
    <tr>
        <td><b>Input value</b></td>
        <td><b>Expected results</b></td>
    </tr>
    <tr>
        <td>"First name" - 65 letters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
    <tr>
        <td>"Last name" - 65 letters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
    <tr>
        <td>"Username" - 65 characters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
    <tr>
        <td>"E-mail" - 65 characters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
    <tr>
        <td>"About yourself" - 257 characters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
    <tr>
        <td>"Password" - 65 characters, other fields valid</td>
        <td>Around the field was displayed error message "Exceeded the allowed number of characters"</td>
    </tr>
</table>

<h3> Test case TMTJ005. Test various field input.</h3>

<p> Steps:</p>
<p>1. Fill fields and choose their options according to the next table.</p>
<table>
    <tr>
        <td><b>Input value</b></td>
        <td><b>Expected results</b></td>
    </tr>
    <tr>
        <td>Enter special chars i.e. !@#$%^ in fields "First Name", "Last Name" and "About Yourself"</td>
        <td>Error message for edited fields "This field allows to enter only letters"</td>
    </tr>
    <tr>
        <td>Enter not numeric values in "Phone Number"</td>
        <td>Error message "This field allows to enter only digits and '+'"</td>
    </tr>
    <tr>
        <td>Enter "a" in "E-mail"</td>
        <td>Error message "Entered value is not valid for e-mail"</td>
    </tr>
    <tr>
        <td>Enter "a@b" in "E-mail"</td>
        <td>Error message "Entered value is not valid for e-mail"</td>
    </tr>
    <tr>
        <td>Enter "a.b" in "E-mail"</td>
        <td>Error message "Entered value is not valid for e-mail"</td>
    </tr>
    <tr>
        <td>Enter "a@b@c.b" in "E-mail"</td>
        <td>Error message "Entered value is not valid for e-mail"</td>
    </tr>
</table>


<h3>Test case TMTJ006. Filling fields "Password" and "Confirm Password" with different values.</h3>

<p> Steps: </p>


<p>1. Fill presented field "Password" with some value and field "Confirm Password" with another value</p>

<p>Expected results</p>

<p>1. There was displayed error message about mismatching of inputted passwords.</p>

<h3>Test case TMTJ007. Testing that Enter key work as a substitute for the "Submit" button</h3>

<p> Steps: </p>


<p>1. Make sure that Enter key work as a substitute for the "Submit" button when the focus is on the fields "First
    Name", "Last Name"
    , "Phone Number", "Username", "E-mail", "About Yourself", "Password" and "Confirm Password".</p>
</body>
</html>
