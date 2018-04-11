@echo off
tasklist /fi "imagename eq Steam.exe" |find ":" > nul
if errorlevel 0 C:\Users\BeyondTheLimit\Desktop\pubg.ink
pause
