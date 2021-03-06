package be.yannickdeturck.lagomshop.order.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;

import java.util.UUID;

/**
 * @author Yannick De Turck
 */
@Value.Immutable
@ImmutableStyle
@JsonDeserialize
public interface AbstractOrder {
    @Value.Parameter
    UUID getId();

    @Value.Parameter
    UUID getItemId();

    @Value.Parameter
    Integer getAmount();

    @Value.Parameter
    String getCustomer();

    @Value.Check
    default void check() {
        Preconditions.checkState(getAmount() > 0, "Amount must be a positive value");
    }
}
