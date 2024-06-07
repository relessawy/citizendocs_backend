podman run --name postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=citizendocs -p 5432:5432 -d postgres:13cd backend
podman cp ./backend/src/main/resources/init.sql postgres:/docker-entrypoint-initdb.d/init.sql
podman exec -it postgres psql -U postgres -d citizendocs -f /docker-entrypoint-initdb.d/init.sql