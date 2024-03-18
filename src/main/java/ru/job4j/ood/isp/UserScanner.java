package ru.job4j.ood.isp;

public interface UserScanner {
    void scanBankCardNumber();

    void scanDocument();

    void scanBarCode();

    void scanFaceForFaceId();
}

class BankCardScanner implements UserScanner {
    @Override
    public void scanBankCardNumber() {
        /* code for scanning bank card number */
    }

    @Override
    public void scanDocument() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanBarCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanFaceForFaceId() {
        throw new UnsupportedOperationException();
    }
}

class DocumentScanner implements UserScanner {
    @Override
    public void scanBankCardNumber() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanDocument() {
        /* code for scanning documents */
    }

    @Override
    public void scanBarCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanFaceForFaceId() {
        throw new UnsupportedOperationException();
    }
}

class BarCodeScanner implements UserScanner {
    @Override
    public void scanBankCardNumber() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanDocument() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanBarCode() {
        /* code for scanning barcode */
    }

    @Override
    public void scanFaceForFaceId() {
        throw new UnsupportedOperationException();
    }
}

class FaceIdScanner implements UserScanner {
    @Override
    public void scanBankCardNumber() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanDocument() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanBarCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scanFaceForFaceId() {
        /* code for face scanning */
    }
}

