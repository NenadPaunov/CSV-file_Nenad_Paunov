# CSV-file_Nenad_Paunov
This program uses standard java libraries and it performs the following tasks:
1. Generating a CSV file containing data from 1000 people. The data are: id, name, surname, date of birth, favorite color and sorting them by date from the newest to the oldest and writing them sorted into the new CSV file of the first x * persons.
The program is receiving three arguments:

- argument 0 - the name of the input CSV file

- argument 1 - the name of the output CSV file

- argument 2 - x * - the number of people to write to the output file, if the argument is not given - enter all persons

2. From output CSV file from previous task it changes the name of the colors that are not primary  from the column "favorite color" into  some of the basic colors (random selection) and thus the changed information is entered to a new CSV file.

3. HTML page which contains a table that displays the data from the output CSV file from the previous task.

The color of the line (s) in the table is the color from the column "favorite color".

  This program can be runned from CMD(Cmd class for running all methods at once or by selecting each class separately) or from main class Pokretanje in IDE.
