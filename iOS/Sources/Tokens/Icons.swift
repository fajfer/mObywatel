import SwiftUI






public enum Icons {
  public enum Outline {
    public enum Symbols {
      public static let copy = Image(name: "AA001_Copy")
      public static let delete = Image(name: "AA002_Delete")
      public static let refresh = Image(name: "AA003_Refresh")
      public static let attachment = Image(name: "AA004_Attachment")
      public static let upload = Image(name: "AA005_Upload")
      public static let download = Image(name: "AA006_Download")
      public static let datePicker = Image(name: "AA007_Date_picker")
      public static let changePassword = Image(name: "AA008_Change_password")
      public static let fingerprint = Image(name: "AA009_Fingerprint")
      public static let internetNotOk = Image(name: "AA010_Internet_not_ok")
      public static let internetOk = Image(name: "AA011_Internet_ok")
      public static let checkMark = Image(name: "AA012_Check_mark")
      public static let changeLoginMethod = Image(name: "AA013_Change_login_metod")
      public static let unrestricted = Image(name: "AA014_Unrestricted")
      public static let changePin = Image(name: "AA015_Change_PIN")
      public static let history = Image(name: "AA016_History")
      public static let faceID = Image(name: "AA017_Face_ID")
      public static let fail = Image(name: "AA018_Fail")
      public static let logout = Image(name: "AA019_Logout")
      public static let payments = Image(name: "AA020_Payments")
      public static let photo = Image(name: "AA021_Photo")
      public static let showPassword = Image(name: "AA022_Show_password")
      public static let hidePassword = Image(name: "AA023_Hide_password")
      public static let devices = Image(name: "AA024_Devices")
      public static let star = Image(name: "AA025_Star")
      public static let timeline = Image(name: "AA026_Timeline")
      public static let crypto = Image(name: "AA027_Crypto")
      public static let deactivate = Image(name: "AA028_Deactivate")
      public static let motionOff = Image(name: "AA029_Motion_off")
      public static let motionOn = Image(name: "AA030_Motion_on")
      public static let link = Image(name: "AA031_Link")
      public static let phone = Image(name: "AA032_Phone")
      public static let addressBook = Image(name: "AA033_Address_book")
      public static let navigate = Image(name: "AA034_Navigate")
      public static let documentBox = Image(name: "AA035_Document_box")
      public static let priceTag = Image(name: "AA036_Price_tag")
      public static let roundedPlus = Image(name: "AA037_rounded_plus")
      public static let roundedMinus = Image(name: "AA038_rounded_minus")
      public static let handle2 = Image(name: "AA039_handle_2")
      public static let handle3 = Image(name: "AA040_handle_3")
      public static let padlock = Image(name: "AA041_padlock")
      public static let opinion = Image(name: "AA042_Opinion")
      public static let locationOff = Image(name: "AA043_Location_off")
      public static let accessibility = Image(name: "AA044_Accessibility")
      public static let creditCard = Image(name: "AA045_Credit_Card")
      public static let bullet = Image(name: "AA046_Bullet")
      public static let creditCardChange = Image(name: "AA047_Credit_card_change")
      public static let verify = Image(name: "AA048_Verify")
      public static let creditCardAdd = Image(name: "AA049_Credit_card_add")
      public static let alert = Image(name: "AA050_Alerts")
      public static let reportIncident = Image(name: "AA051_Report_an_incident")
      public static let filters = Image(name: "AA052_Filters")
      public static let vouchersAndSupplement = Image(name: "AA053_Bony_i_dodatki")
      public static let floodAlert = Image(name: "AA054_Alert_powodziowy")
      public static let pause = Image(name: "AA055_Pauza")
      public static let image = Image(name: "AA056_Image")
      public static let funnel = Image(name: "AA057_Funnel")
      public static let bulletedList = Image(name: "AA058_Bulleted_list")
      public static let minus = Image(name: "AA059_Minus")
      public static let filter = Image(name: "AA060_Filter")
      public static let cogArrowPath = Image(name: "AA061_Cog_arrow_path")
      public static let arrowTurnDown = Image(name: "AA062_Arrow_turn_down")
      public static let spinner = Image(name: "AA063_Spinner")
      public static let floppyDisk = Image(name: "AA064_Floppy_disk")
      public static let printer = Image(name: "AA065_Printer")
      public static let archives = Image(name: "AA066_Archives")
      public static let folderArrowUp = Image(name: "AA067_Folder_arrow_up")
      public static let grid = Image(name: "AA068_Grid")
      public static let gridOff = Image(name: "AA069_Grid_off")
      public static let restrictDocument = Image(name: "AA070_Restrict_document")
      public static let suspendIdentity = Image(name: "AA071_Zawieszanie_dowodu")
      public static let invalidateIdentity = Image(name: "AA072_Uniewaznienie_dowodu")
    }

    public enum Navigation {
      public static let home = Image(name: "AB001_Home")
      public static let search = Image(name: "AB002_Search")
      public static let settings = Image(name: "AB003_Settings")
      public static let arrowLeft = Image(name: "AB004_Arrow_left")
      public static let chevronLeft = Image(name: "AB005_Chevron_left")
      public static let chevronRight = Image(name: "AB006_Chevron_right")
      public static let chevronUp = Image(name: "AB007_Chevron_up")
      public static let chevronDown = Image(name: "AB008_Chevron_down")
      public static let xmark = Image(name: "AB009_X_mark", accessibilityLabel: .accessibilityClose)
      public static let more = Image(name: "AB010_More")
      public static let moreVertical = Image(name: "AB011_More_vertical")
      public static let moreHorizontal = Image(name: "AB012_More_horizontal")
      public static let notifications = Image(name: "AB013_Notifications")
      public static let shareDots = Image(name: "AB014_Share")
      public static let help = Image(name: "AB015_Help", accessibilityLabel: .accessibilityFindOutMore)
      public static let add = Image(name: "AB016_Add")
      public static let edit = Image(name: "AB017_Edit")
      public static let shareArrow = Image(name: "AB018_Share")
      public static let logout = Image(name: "AB019_Logout")
      public static let capslock = Image(name: "AB020_Capslock")
      public static let reply = Image(name: "AB021_Reply")
      public static let forward = Image(name: "AB022_Forward")
      public static let zoomIn = Image(name: "AB023_Zoom_in")
      public static let sort = Image(name: "AB024_Sort")
      public static let notificationsWithDot = Image(name: "AB025_Notifications_with_dot")
    }

    public enum Services {
      public static let services = Image(name: "AC001_Services")
      public static let penaltyPoints = Image(name: "AC002_Penalty_points")
      public static let peselVerification = Image(name: "AC003_Verify_pesel")
      public static let peselRestriction = Image(name: "AC004_Lock_pesel")
      public static let veryGoodAir = Image(name: "AC005_Very_good_air")
      public static let satisfactoryAir = Image(name: "AC006_Satisfactory_air")
      public static let belowNormalAir = Image(name: "AC007_Air_below_normal")
      public static let harmfulAir = Image(name: "AC008_Harmful_air")
      public static let lifeThreateningAir = Image(name: "AC009_Life_threatening_air")
      public static let dangerousAir = Image(name: "AC010_Dangerous_air")
      public static let vehicleHistory = Image(name: "AC011_Vehicle_history")
      public static let zusVisit = Image(name: "AC012_ZUS_e-appointment")
      public static let ticket = Image(name: "AC013_Ticket")
      public static let mStluczka = Image(name: "AC014_mStluczka")
      public static let safeBus = Image(name: "AC015_Safe_bus")
      public static let elections = Image(name: "AC016_Elections")
    }

    public enum People {
      public static let addPerson = Image(name: "AD001_Add_person")
      public static let selectedPerson = Image(name: "AD002_Selected_person")
      public static let shareWithPerson = Image(name: "AD003_Share_with_person")
      public static let person = Image(name: "AD004_Person")
      public static let framedPerson = Image(name: "AD005_Framed_person")
      public static let manyUsers = Image(name: "AD006_Many_users")
      public static let userCog = Image(name: "AD007_User_cog")
      public static let family = Image(name: "AD008_Family")
    }

    public enum Documents {
      public static let publishedCertificate = Image(name: "AE001_Published_certificate")
      public static let updateCertificate = Image(name: "AE002_Update_certificate")
      public static let legalInformation = Image(name: "AE003_Legal_information")
      public static let powerOfAttorney = Image(name: "AE004_Power_of_attomey")
      public static let documentData = Image(name: "AE005_Document_data")
      public static let document = Image(name: "AE006_Document")
      public static let forwardDocument = Image(name: "AE007_Forward_document")
      public static let approvedDocument = Image(name: "AE008_Approved_document")
      public static let shareDocument = Image(name: "AE009_Share_document")
      public static let addDocument = Image(name: "AE010_Add_document")
      public static let downloadDocument = Image(name: "AE011_Download_document")
      public static let internationalDocument = Image(name: "AE012_International_document")
      public static let magnifyingGlass = Image(name: "AE013_Magnifying_glass")
    }

    public enum Communication {
      public static let chatbot = Image(name: "AF001_Chat_bot")
      public static let chat = Image(name: "AF002_Chat")
      public static let send = Image(name: "AF003_Send")
      public static let cases = Image(name: "AF004_Cases")
      public static let idea = Image(name: "AF005_Idea")
      public static let videoCall = Image(name: "AF006_video_call")
    }

    public enum Places {
      public static let office = Image(name: "AG001_Office")
      public static let officeLocalization = Image(name: "AG002_Office_localization")
      public static let pin = Image(name: "AG003_Pin")
      public static let map = Image(name: "AG004_Map")
      public static let globe = Image(name: "AG005_Globe")
      public static let registrationData = Image(name: "AG006_Registration_data")
      public static let factory = Image(name: "AG007_Factory")
      public static let blockOfFlats = Image(name: "AG008_Block_of_flats")
      public static let homePin = Image(name: "AG009_Home_pin")
    }

    public enum Hands {
      public static let like = Image(name: "AH001_Like")
      public static let dislike = Image(name: "AH002_Dislike")
      public static let pointer = Image(name: "ah003_pointer")
    }

    public enum QrIdentity {
      public static let scannerQr = Image(name: "AI001_Scanner_QR")
      public static let confirmIdentity = Image(name: "AI002_Confirm_identity")
      public static let checkDocument = Image(name: "AI003_Check_document")
      public static let qrCodeWeb = Image(name: "AI004_QR_code_WEB")
      public static let qrCodeMobile = Image(name: "AI005_QR_code_mobile")
      public static let codeMobile = Image(name: "AI006_Code_mobile")
    }

    public enum Vehicles {
      public static let car = Image(name: "AJ001_Car")
      public static let carCheck = Image(name: "AJ002_Car_check")
      public static let bus = Image(name: "AJ003_Bus")
      public static let lorry = Image(name: "AJ004_Lorry")
      public static let train = Image(name: "AJ005_Train")
      public static let tractor = Image(name: "AJ006_Tractor")
      public static let motorcycle = Image(name: "AJ007_Motorcycle")
      public static let scooter = Image(name: "AJ008_Scooter")
    }
  }

  public enum Filled {
    public static let home = Image(name: "B001_Home")
    public static let framedPerson = Image(name: "B002_Framed_person")
    public static let scannerQr = Image(name: "B003_Scanner_QR")
    public static let services = Image(name: "B004_Services")
    public static let more = Image(name: "B005_More")
    public static let plus = Image(name: "B006_Plus")
    public static let minus = Image(name: "B007_Minus")
    public static let info = Image(name: "B008_Info")
    public static let checkMark = Image(name: "b009_check_mark")
    public static let xMark = Image(name: "b010_x_mark")
    public static let exclamationMark = Image(name: "b011_exclamation_mark")
    public static let noticeMark = Image(name: "B012_notice_mark")
    public static let like = Image(name: "B013_Like")
    public static let dislike = Image(name: "B014_Dislike")
    public static let pin = Image(name: "B015_Pin")
    public static let settings = Image(name: "B016_Settings")
  }

  public enum Support {
    public static let info = Image(name: "C1_Info", accessibilityLabel: .accessibilityInfo)
    public static let warning = Image(name: "C2_Warning_mark")
    public static let error = Image(name: "C3_Error_mark")
    public static let success = Image(name: "C4_Success")
  }

  public enum Brand {
    public enum Services {
      public static let penaltyPoints = Image(name: "DA001_Punkty_karne")
      public static let environmentalViolation = Image(name: "DA002_Naruszenie_srodowiskowe")
      public static let abroadInfo = Image(name: "DA003_Polak_za_granica")
      public static let medicalPrescriptions = Image(name: "DA004_eRecepta")
      public static let electricalSupplement = Image(name: "DA005_Dodatek_energetyczny")
      public static let trainTickets = Image(name: "DA006_Bilkom")
      public static let coalSupplement = Image(name: "DA007_Dodatek_gazowy")
      public static let peselRestriction = Image(name: "DA008_Zastrzez_pesel")
      public static let peselVerification = Image(name: "DA009_Weryfikuj_pesel")
      public static let safeBus = Image(name: "DA010_Bezpieczny_autobus")
      public static let electoralRegister = Image(name: "DA011_CRW")
      public static let airQuality = Image(name: "DA012_Czyste_powietrze")
      public static let payments = Image(name: "DA013_ePlatnosci")
      public static let zusVisit = Image(name: "DA014_eWizyta_w_ZUS")
      public static let vehicleHistory = Image(name: "DA015_Historia_pojazdu")
      public static let energyLimit = Image(name: "DA016_Limit_energii")
      public static let powerOfAttorney = Image(name: "DA017_Pelnomocnictwa")
      public static let heatSupplement = Image(name: "DA018_Dodatek_do_ciepla")
      public static let veryGoodAir = Image(name: "DA019_Very_good_air")
      public static let satisfactoryAir = Image(name: "DA020_Satisfactory_air")
      public static let belowNormalAir = Image(name: "DA021_Air_below_normal")
      public static let harmfulAir = Image(name: "DA022_Harmful_air")
      public static let lifeThreateningAir = Image(name: "DA023_Life_threatening_air")
      public static let dangerousAir = Image(name: "DA024_Dangerous_air")
      public static let fines = Image(name: "DA025_Ticket")
      public static let yourInboxes = Image(name: "DA026_Your_inboxes")
      public static let yourAffairs = Image(name: "da027_your_affairs")
      public static let taxOffice = Image(name: "da028_tax_office")
      public static let news = Image(name: "da029_news")
      public static let signTheDocument = Image(name: "DA030_Sign_the_document")
      public static let mBiznes = Image(name: "DA031_mBiznes")
      public static let mStluczka = Image(name: "DA032_mStluczka")
      public static let energyVoucher = Image(name: "DA033_Bon_energetyczny")
      public static let requestForIdCard = Image(name: "DA034_Wniosek_o_dowod")
      public static let networkSecurityIssues = Image(name: "DA035_Bezpiecznie_w_sieci")
      public static let requestForPassport = Image(name: "DA036_Wniosek_o_paszport")
      public static let floodAlert = Image(name: "DA037_Alert_powodziowy")
      public static let applicationForm = Image(name: "DA038_Zloz_wniosek")
      public static let idCardSuspension = Image(name: "DA039_Zawieszanie_dowodu")
      public static let idCardCancellation = Image(name: "DA040_Uniewaznienie_dowodu")
      public static let driverQualifications = Image(name: "DA041_Uprawnienia_kierowcow")
      public static let documentRestriction = Image(name: "DA042_Restrict_document")
      public static let idCardVerification = Image(name: "DA043_Sprawdzenie_dowodu")
    }

    public enum Documents {
      public static let identityCard = Image(name: "DB001_mDowod")
      public static let drivingLicense = Image(name: "DB002_Prawo_jazdy")
      public static let vehicle = Image(name: "DB003_mPojazd")
      public static let covidCertificate = Image(name: "DB004_Unijny_Certyfikat_COVID")
      public static let malopolskaMetropolitanCard = Image(name: "DB005_Malopolska_karta_aglomeracyjna")
      public static let largeFamilyCard = Image(name: "DB006_Karta_duzej_rodziny")
      public static let diia = Image(name: "DB007_Diia")
      public static let schoolCard = Image(name: "DB008_Legitymacja_szkolna")
      public static let studentCard = Image(name: "DB009_Legitymacja_studencka")
      public static let pensionerCard = Image(name: "DB010_Legitymacja_emeryta_rencisty")
      public static let trainsDiscountCard = Image(name: "DB011_Legitymacja_UUT")
      public static let deputyCard = Image(name: "DB012_Legitymacja_poselska")
      public static let attorneyCard = Image(name: "DB013_Legitymacja_adwokacka")
      public static let doctorLicense = Image(name: "DB014_PWZ_lekarz")
      public static let localDocument = Image(name: "DB015_Dokument_generyczny")
      public static let midwifeLicense = Image(name: "DB016_PWZ_polozna")
      public static let nurseLicense = Image(name: "DB017_PWZ_pielegniarka")
      public static let dentistLicense = Image(name: "DB018_PWZ_dentysta")
      public static let attorneyAtLawCard = Image(name: "DB019_Legitymacja_radcy_prawnego")
      public static let attorneyAtLawTraineeCard = Image(name: "DB020_Legitymacja_aplikanta_radcowskiego")
      public static let senatorLicense = Image(name: "DB021_Legitymacja_senatorska")
      public static let pzpnPlayerLicense = Image(name: "DB022_Legitymacja_zawodnika_PZPN")
      public static let pzpnCoachLicense = Image(name: "DB023_Legitymacja_trenera_PZPN")
      public static let disabledPersonLicense = Image(name: "DB024_Legitymacja_osoby_niepelnosprawnej")
      public static let bloodDonorLicense = Image(name: "DB025_Legitymacja_dawcy_krwi")
      public static let boneMarrowDonorLicense = Image(name: "DB026_Legitymacja_dawcy_szpiku")
      public static let phdStudentCard = Image(name: "DB027_Legitymacja_doktoranta")
      public static let laboratoryDiagnosticianCard = Image(name: "DB028_Legitymacja_diagnosty_laboratoryjnego")
      public static let teacherIdentityCard = Image(name: "DB029_Legitymacja_nauczyciela")
      public static let courtBailiffId = Image(name: "DB030_Identyfikator_komornika_sadowego")
      public static let civilEngineerLicense = Image(name: "DB031_Legitymacja_inzyniera_budownictwa")
      public static let taxAdvisorCard = Image(name: "DB032_Legitymacja_doradcy_podatkowego")
      public static let statutoryAuditorCard = Image(name: "DB033_Legitymacja_bieglego_rewidenta")
    }
  }

  public enum Dedicated {
    public static let errorMarkSmall = Image(name: "E001_Error_mark_small")
    public static let external = Image(name: "E002_External")
    public static let badge = Image(name: "E003_Badge")
    public static let xMarkSmall = Image(name: "E004_X_mark_small", accessibilityLabel: .accessibilityClose)
    public static let checkMark = Image(name: "E005_Check_mark")
    public static let checkboxMark = Image(name: "E006_Checkbox_mark")
    public static let exclamationMark = Image(name: "E007_Exclamation_mark")
  }

  public enum Result {
    public static let info = Image(name: "f1_info")
    public static let warning = Image(name: "f2_warning_mark")
    public static let failure = Image(name: "f3_failure")
    public static let success = Image(name: "f4_success")
  }

  public enum EmptyState {
    public static let bell = Image(name: "G001_Bell_big")
    public static let documentBox = Image(name: "G002_Document_box_big")
    public static let peselVerification = Image(name: "g003_check_pesel")
    public static let peselRestriction = Image(name: "g004_secure_pesel")
    public static let mBiznes = Image(name: "G005_mBiznes")
    public static let addressBook = Image(name: "G006_Address_book")
    public static let signTheDocument = Image(name: "G007_Sign_the_document")
    public static let id = Image(name: "G008_ID")
    public static let payments = Image(name: "G009_ePlatnosci")
    public static let idea = Image(name: "G010_Idea")
    public static let requestForPassport = Image(name: "G011_Wniosek_o_paszport")
    public static let submitApplication = Image(name: "G012_Zloz_wniosek")
    public static let registrationDate = Image(name: "G013_Registration_data")
    public static let idCardSuspension = Image(name: "G014_Zawieszanie_dowodu")
    public static let idCardCancellation = Image(name: "G015_Uniewaznienie_dowodu")
    public static let vehicleCollision = Image(name: "G016_Stluczka")
    public static let fingerprint = Image(name: "G017_Fingerprint")
    public static let restrictDocument = Image(name: "G018_Restrict_document")
    public static let homePin = Image(name: "G019_Home_pin")
  }

  public enum Lift {
    public enum Documents {
      public static let cardLogoDefault = Image(name: "IA001_Card_logo_default")
      public static let cardLogoZUS = Image(name: "IA002_Card_logo_ZUS")
      public static let cardLogoKDR = Image(name: "IA003_Card_logo_KDR")
      public static let cardLogoLawyer = Image(name: "IA004_Card_logo_lawyer")
      public static let cardLogoUUT = Image(name: "IA005_Card_logo_UUT")
      public static let cardLogoNurse = Image(name: "IA006_Card_logo_PWZ_Nurse")
      public static let cardLogoMidwife = Image(name: "IA007_Card_logo_PWZ_Midwife")
      public static let cardLogoAdvisor = Image(name: "IA008_Card_logo_advisor")
      public static let cardLogoLON = Image(name: "IA009_Card_logo_LON")
      public static let cardLogoKRK = Image(name: "IA010_Card_logo_KRK")
      public static let cardLogoDoctor = Image(name: "IA011_PWZ_lekarza_asset")
    }

    public enum CardMini {
      public static let identityCard = Image(name: "IB001_mDowod_card_mini")
      public static let pensionerCard = Image(name: "IB002_Emeryt_card_mini")
      public static let drivingLicense = Image(name: "IB003_PJ_card_mini")
      public static let vehicles = Image(name: "IB004_mPojazd_card_mini")
      public static let largeFamilyCard = Image(name: "IB005_KDR_card_mini")
      public static let schoolCard = Image(name: "IB006_LSzkolna_card_mini")
      public static let studentCard = Image(name: "IB007_LStudencka_card_mini")
      public static let attorneyCard = Image(name: "IB008_LAdwokacka_card_mini")
      public static let deputyCard = Image(name: "IB009_LPoselska_card_mini")
      public static let trainsDiscount = Image(name: "IB010_UUT_card_mini")
      public static let diia = Image(name: "IB011_DIIA_card_mini")
      public static let nurseLicense = Image(name: "IB012_PWZPielegniarka_card_mini")
      public static let midwifeLicense = Image(name: "IB013_PWZPolozna_card_mini")
      public static let doctorLicense = Image(name: "IB014_PWZLekarz_card_mini")
      public static let dentistLicense = Image(name: "IB015_PWZDentysta_card_mini")
      public static let attorneyAtLawCard = Image(name: "IB016_Legitymacja_radcy_prawnego_card_mini")
      public static let disabledPersonLicense = Image(name: "IB017_Legitymacja_osoby_niepelnosprawnej_card_mini")
      public static let senatorLicense = Image(name: "IB018_Legitymacja_senatorska_card_mini")
      public static let teacherIdentityCard = Image(name: "IB019_Legitymacja_Sluzbowa_Nauczyciela_card_mini")
      public static let genericDocument = Image(name: "IB020_Dokument_generyczny_card_mini")
      public static let courtBailiffId = Image(name: "IB021_Identyfikator_komornika_sadowego_card_mini")
      public static let neutralDocument = Image(name: "IB022_Dokument_neutralny_card_mini")
      public static let taxAdvisor = Image(name: "IB023_Doradca_podatkowy_card_mini")
    }

    public enum Brand {
      public static let medicalPrescriptions = Image(name: "IC001_recepty")
      public static let company = Image(name: "IC002_firma")
      public static let documentSign = Image(name: "IC003_podpisz_wniosek")
      public static let penaltyPoints = Image(name: "IC004_punkty_karne")
      public static let fines = Image(name: "IC005_mandaty")
      public static let vehicleHistory = Image(name: "IC006_historia_pojazdu")
      public static let environmentalViolation = Image(name: "IC007_naruszenie_srodowiskowe")
      public static let airQuality = Image(name: "IC008_jakosc_powietrza")
      public static let floodAlert = Image(name: "IC009_alert_powodziowy")
      public static let networkSecurityIssues = Image(name: "IC010_bezpieczenstwo_w_sieci")
      public static let electoralRegister = Image(name: "IC011_wybory")
      public static let peselVerification = Image(name: "IC012_sprawdz_PESEL")
      public static let peselRestriction = Image(name: "IC013_zastrzez_PESEL")
      public static let payments = Image(name: "IC014_ePlatnosci")
      public static let zusVisit = Image(name: "IC015_e-wizytwa_w_ZUS")
      public static let safeBus = Image(name: "IC016_bezpieczny_autobus")
      public static let trainTickets = Image(name: "IC017_bilkom")
      public static let malopolskaMetropolitanCard = Image(name: "IC018_karta_MKA")
      public static let abroadInfo = Image(name: "IC019_polak_za_granica")
      public static let applicationFormServices = Image(name: "IC020_zloz_dokument")
      public static let yourCases = Image(name: "IC021_twoje_sprawy")
      public static let landRegistry = Image(name: "IC022_ksiegi_wieczyste")
      public static let vehicleCollision = Image(name: "IC023_stluczka")
      public static let driverQualifications = Image(name: "IC024_uprawnienia_kierowcy")
      public static let internetGovPl = Image(name: "IC025_internet_gov_pl")
      public static let other = Image(name: "IC026_pozostale")
      public static let bankingPZ = Image(name: "IC027_profil_zaufany_bankowosc")
      public static let otherServices = Image(name: "IC028_inne_uslugi")
      public static let restrictDocument = Image(name: "IC029_zastrzez_dokument")
      public static let favorite = Image(name: "IC030_ulubione")
    }

    public enum Devices {
      public static let activeOverlapLayout = Image(name: "ID001_active_overlap_layout")
      public static let activeGridLayout = Image(name: "ID002_active_grid_layout")
      public static let activeStackLayout = Image(name: "ID003_active_stack_layout")
      public static let inactiveOverlapLayout = Image(name: "ID004_inactive_overlap_layout")
      public static let inactiveGridLayout = Image(name: "ID005_inactive_grid_layout")
      public static let inactiveStackLayout = Image(name: "ID006_inactive_stack_layout")
      public static let overlapLayout = Image(name: "ID007_overlap_layout")
      public static let gridLayout = Image(name: "ID008_grid_layout")
      public static let stackLayout = Image(name: "ID009_stack_layout")
    }

    public enum StatusCard {
      public static let info = Image(name: "IE001_info")
      public static let noticeMark = Image(name: "IE002_notice_mark")
      public static let xMark = Image(name: "IE003_x_mark")
      public static let checkMark = Image(name: "IE004_check_mark")
    }

    public enum BottomBar {
      public static let documents = Image(name: "IF001_Documents")
      public static let services = Image(name: "IF002_Services")
      public static let search = Image(name: "IF003_Search")
      public static let scan = Image(name: "IF004_Scan")
      public static let more = Image(name: "IF005_More")
      public static let documentsFill = Image(name: "IF006_Documents_fill")
      public static let servicesFill = Image(name: "IF007_Services_fill")
      public static let searchFill = Image(name: "IF008_Search_fill")
      public static let scanFill = Image(name: "IF009_Scan_fill")
      public static let moreFill = Image(name: "IF010_More_fill")
    }
  }

  public enum Components {
    public static let fileUpload = Image(name: "J001_File_upload")
  }
}

public extension Image {
  init(name: String, accessibilityLabel: String? = nil) {
    if let accessibilityLabel {
      self.init(name, bundle: .module, label: Text(accessibilityLabel))
    } else {
      self.init(name, bundle: .module)
    }
  }
}

public extension CGFloat {
  static let smallIcon = 20.0
  static let regularIcon = 24.0
  static let smallIconPageIcon = 64.0
  static let largeIconPageIcon = 96.0
}
