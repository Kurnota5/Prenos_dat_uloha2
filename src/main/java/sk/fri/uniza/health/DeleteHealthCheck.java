package sk.fri.uniza.health;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.hibernate.UnitOfWork;
import sk.fri.uniza.db.DataDAO;
import sk.fri.uniza.db.FieldDAO;

public class DeleteHealthCheck extends HealthCheck {
    FieldDAO fieldDAO;

    public DeleteHealthCheck(FieldDAO fieldDAO) {
        this.fieldDAO = fieldDAO;
    }

    @Override
    @UnitOfWork
    protected Result check() throws Exception {
        fieldDAO.delete("weather");
        fieldDAO.delete("airTemp");
        fieldDAO.delete("windSpeed");
        return Result.healthy();
    }
}
