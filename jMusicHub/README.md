# jMusicHub
## Object Oriented Programming Project in Java, 3rd year, ESIEA
### Project produced by LEJEUNE Gaël and CHAUVREAU-MANAT
Program used to manage a music library in a terminal.

### Description
The program allows you to manage a music library containing audiobooks, music tracks, playlists, and albums.
The program is build to work with real files. You can create your own files in "files/music" to try it out. The extension doesn't matter and the program works fine with ".txt" files.

### Available commands
#### c :
add a new song

#### l :
add a new audio book

#### a :
add a new album

#### + :
add an existing song to an album

#### p :
Creation of a new playlist from existing songs and audiobooks

#### - :
delete a playlist

#### s :
save playlists, albums, songs and audiobooks in the respective xml files

#### d :
display all the registered elements
#### variants :
    - dab : display registered audio book ordered by author
    - da : display all the registered albums
    - dsa : display a specific registered album
    - dad : display registered albums ordered by release date
    - dag : display a registered album songs ordered by genre
    - dp : display all registered playlists
    - dsp : display a specific registered playlist

#### q :
exit the jMusicHub
#### h :
help with details of previous commands
