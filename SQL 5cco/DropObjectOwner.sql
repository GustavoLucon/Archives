accept vowner prompt "Owner: "
spool c:\temp\ddl.sql
SELECT 'DROP ' || OBJECT_TYPE || ' ' || OWNER || '.' || OBJECT_NAME || ';'
FROM DBA_OBJECTS
WHERE OWNER = '&&vowner'
ORDER BY OBJECT_TYPE, OBJECT_NAME;
spool off
