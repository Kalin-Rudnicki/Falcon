
# Falcon

Command line parsing library for scala

## What to expect

- `-a -b -c` = `-abc`
- `-a` = `--all`
- `--a-b-c` = `--always-buy-candy`
- `--nest1:nest2:arg-name`
- `--a b` = `--a=b`

## The main attraction: Command line completion

When running a program that is parsing command line arguments with `falcon`, if it sees the argument `--falcon:complete`,  
then it knows it's not actually supposed to run your program, but rather utilize the parser to auto-complete arguments
