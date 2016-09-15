package org.openfact.models.ubl.common;

public enum CurrencyCodeContentType {

    AED,

    AFN,

    ALL,

    AMD,

    ANG,

    AOA,

    ARS,

    AUD,

    AWG,

    AZM,

    BAM,

    BBD,

    BDT,

    BGN,

    BHD,

    BIF,

    BMD,

    BND,

    BOB,

    BRL,

    BSD,

    BTN,

    BWP,

    BYR,

    BZD,

    CAD,

    CDF,

    CHF,

    CLP,

    CNY,

    COP,

    CRC,

    CUP,

    CVE,

    CYP,

    CZK,

    DJF,

    DKK,

    DOP,

    DZD,

    EEK,

    EGP,

    ERN,

    ETB,

    EUR,

    FJD,

    FKP,

    GBP,

    GEL,

    GHC,

    GIP,

    GMD,

    GNF,

    GTQ,

    GYD,

    HKD,

    HNL,

    HRK,

    HTG,

    HUF,

    IDR,

    ILS,

    INR,

    IQD,

    IRR,

    ISK,

    JMD,

    JOD,

    JPY,

    KES,

    KGS,

    KHR,

    KMF,

    KPW,

    KRW,

    KWD,

    KYD,

    KZT,

    LAK,

    LBP,

    LKR,

    LRD,

    LSL,

    LTL,

    LVL,

    LYD,

    MAD,

    MDL,

    MGF,

    MKD,

    MMK,

    MNT,

    MOP,

    MRO,

    MTL,

    MUR,

    MVR,

    MWK,

    MXN,

    MYR,

    MZM,

    NAD,

    NGN,

    NIO,

    NOK,

    NPR,

    NZD,

    OMR,

    PAB,

    PEN,

    PGK,

    PHP,

    PKR,

    PLN,

    PYG,

    QAR,

    ROL,

    RUB,

    RWF,

    SAR,

    SBD,

    SCR,

    SDD,

    SEK,

    SGD,

    SHP,

    SIT,

    SKK,

    SLL,

    SOS,

    SRG,

    STD,

    SVC,

    SYP,

    SZL,

    THB,

    TJS,

    TMM,

    TND,

    TOP,

    TRL,

    TTD,

    TWD,

    TZS,

    UAH,

    UGX,

    USD,

    UYU,

    UZS,

    VEB,

    VND,

    VUV,

    WST,

    XAF,

    XAG,

    XAU,

    XCD,

    XDR,

    XOF,

    XPD,

    XPF,

    XPT,

    YER,

    YUM,

    ZAR,

    ZMK,

    ZWD;

    public String value() {
        return name();
    }

    public static CurrencyCodeContentType fromValue(String v) {
        return valueOf(v);
    }

}
