# leader_board

An online game requires a leaderboard to be created with capabilities mentioned below. Sample command names to be used are enclosed in [].

Design the leaderboard keeping all data in-memory.

[UPSERT_USER] Upsert user name along with email-id and country that he/she belongs to. Default score for a user is 0.
[UPSERT_SCORE] Upsert score for a given user.
[GET_TOP] Get the top k rank holders at a gi	ven point of time taking k as input. Country is an optional argument. If country is provided then return top k users of a country else at a global level. If there is a tie on score, the user who recorded the score first will get precedence. 
[GET_USERS_WITH_SCORE] Get all the users having a given score s as input.
[SEARCH] Implement a search capability where based on given certain filter parameters name, score and country - in this order - users matching the criteria are returned. For example, queries such as give me all users who are Indians and having score equal to 4. All parameters for the search are optional.


Bonus:
1 . Implement the following Filters 
[GET_RANGE] Rank range filter - Given a range of ranks, return all the users having this rank.
[SEARCH_NAME] Name substring filter - Given a substring, return all matching (partial and full) user names

Note: Upsert is Update or Insert

The input contains the command followed by the arguments.

Example Input
UPSERT_USER, Nikhil, India, nikhil@flipkart.com
UPSERT_USER, Rahul, India, rahul@flipkart.com
UPSERT_SCORE, rahul@flipkart.com, 1
UPSERT_SCORE, nikhil@flipkart.com, 5
UPSERT_USER, Karan, Argentina, karan@flipkart.com
UPSERT_SCORE, karan@flipkart.com, 1
GET_TOP, 3
GET_USERS_WITH_SCORE, 1
GET_TOP, 2, India
SEARCH, Nikhil, null, India 
SEARCH,null, null, India
[Bonus]GET_RANGE, 1, 2
[Bonus]SEARCH_NAME, Nik
