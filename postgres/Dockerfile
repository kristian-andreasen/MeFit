FROM postgres:13.5

# Set environment variables
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB mefitdocker

# Copy the initialization script
COPY data.sql /docker-entrypoint-initdb.d/

# Expose the database port
EXPOSE 5432
