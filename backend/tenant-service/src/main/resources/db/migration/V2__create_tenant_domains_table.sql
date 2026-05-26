CREATE TABLE tenant_domains (

    id UUID PRIMARY KEY,

    tenant_id UUID NOT NULL,

    domain VARCHAR(255) UNIQUE NOT NULL,

    verified BOOLEAN DEFAULT FALSE,

    primary_domain BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_tenant
        FOREIGN KEY (tenant_id)
        REFERENCES tenants(id)
        ON DELETE CASCADE
);