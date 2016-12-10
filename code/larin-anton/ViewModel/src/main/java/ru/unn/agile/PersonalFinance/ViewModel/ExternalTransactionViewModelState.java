package ru.unn.agile.PersonalFinance.ViewModel;

import java.time.LocalDate;

class ExternalTransactionViewModelState {
    private final int amount;
    private final boolean isIncome;
    private final LocalDate date;
    private final CategoryViewModel category;
    private final String counterparty;
    private final String description;

    private ExternalTransactionViewModelState(final ExternalTransactionViewModel transaction) {
        amount = transaction.getAmount();
        isIncome = transaction.getIsIncome();
        date = transaction.getDate();
        category = transaction.getCategory();
        counterparty = transaction.getCounterparty();
        description = transaction.getDescription();
    }

    static ExternalTransactionViewModelState save(final ExternalTransactionViewModel transaction) {
        return new ExternalTransactionViewModelState(transaction);
    }

    void recover(final ExternalTransactionViewModel transaction) {
        transaction.setAmount(amount);
        transaction.setIsIncome(isIncome);
        transaction.setDate(date);
        transaction.setCategory(category);
        transaction.setCounterparty(counterparty);
        transaction.setDescription(description);
    }
}
