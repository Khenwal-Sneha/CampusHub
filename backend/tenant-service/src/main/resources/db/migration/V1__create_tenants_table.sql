CREATE TABLE tenants (

    id UUID PRIMARY KEY,

    college_name VARCHAR(255) NOT NULL,

    slug VARCHAR(255) UNIQUE NOT NULL,

    official_email VARCHAR(255),

    official_phone VARCHAR(50),

    website VARCHAR(255),

    address TEXT,

    status VARCHAR(50) NOT NULL,

    verified BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);