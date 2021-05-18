# Input-Validator
This program simulates a telephone address book where a user should be able to insert a new contact, delete a contact by name or phone number, and list all the contacts within the phone book.

No dependency required.
Commands to run are:
    javac PhoneBook.java
    java PhoneBook


Sample Inputs –
Acceptable Inputs for name:
Jane Johnson 
Johnson, Jane Doe
Johnson, Jane D.
Jane Doe Johnson,
Jane Johnson-Smith
Johnson-Smith, Jane D.
Jane O’Malley-Johnson

Unacceptable Inputs for name:
Jane Thompson-Smith-Johnson 
<Script>alert(“XSS”)</Script> 
Jane Doe Mae Johnson 
Select * from users;
Jane3333 Johnson1

Acceptable Inputs for phone:
3011231234 
(301)123-1234 
301-123-1234 
+1(301)123-1234 
+32(21)122-1222 
12345 
1(301)111-1111 
12345.12345
011 1 703 111 1234 
011 701 111 1234

Unacceptable Inputs for phone:
234
1/703/123/1234 
(001)123-4567
(301)123-2345 ext 333 
+01(301)123-1234 
+1234(301)123-1234 
3011111234567
Pp 301-222-2222 
<Script>alert(“XSS”)</Script>