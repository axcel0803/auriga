//���l
-	script	NoviceExchange	-1,{
	if(Weight*100/MaxWeight >= 90) {
		mes "[���l]";
		mes "���������I";
		mes "���͂���Ȃ�������";
		mes "���ł���ȂɎ��������Ă�񂾁H";
		mes "�J�v���̑q�ɂɂł��a���Ă����B";
		close;
	}
	set '@code,strnpcinfo(5);	//���ʎq��#�ȍ~�̕�������Q�Ƃ��Đ��l�ɕϊ�
	switch('@code) {
		case 0:	//prontera
			setarray '@need,935,914,909;	//��������A�ȖсA�[���s�[
			setarray '@amount,5,10,10;	
			break;
		case 1:	//geffen
			setarray '@need,935,915,909;	//��������A���Ȃ��̔�A�[���s�[
			setarray '@amount,5,6,10;
			break;
		case 2:	//morocc
			setarray '@need,935,916,909;	//��������A���̉H�сA�[���s�[
			setarray '@amount,5,7,10;
			break;
		case 3:	//aldebaran
			setarray '@need,955,916,909;	//峂̔�A���̉H�сA�[���s�[
			setarray '@amount,1,7,10;
			break;
		case 4:	//payon
			setarray '@need,902,909;	//�؂̍��A�[���s�[�A0
			setarray '@amount,6,10;
			break;
	}
	mes "[���l]";
	mes "����ɂ��́I";
	mes "���̂��u" +getitemname('@need[0])+ "�v��u" +getitemname('@need[1])+ "�v";
	mes "�Ƃ����A�C�e���������ĂȂ����H";
	if('@code < 4)
		mes "���A�u�[���s�[�v�ł��������B";
	mes "���������Ă���A���ɏ���";
	mes "�����Ă���Ȃ����B";
	next;
	mes "[���l]";
	mes "�������A�����ł��炨���Ȃ��";
	mes "�킯����Ȃ��B�������ȁc�c";
	mes "�u" +getitemname('@need[0]) + '@amount[0]+ "�v���u" +getitemname('@need[1]) + '@amount[1]+ "�v";
	if('@code < 4)
		mes "�܂��́u�[���s�[10�v��";
	mes "�u�ԃ|�[�V����1�v��";
	mes "��������̂͂ǂ����H";
	next;
	switch (select("�����ł���I","���������Ă�C���c�c","���ł��I")) {
	case 1:
		mes "[���l]";
		mes "�u" +getitemname('@need[0])+ "�v���u" +getitemname('@need[1])+ "�v";
		if('@code < 4)
			mes "�������́u�[���s�[�v�B";
		mes "�����A�ǂ�ƌ�������񂾁H";
		next;
		if('@code<4)
			set '@talk$,"�u�[���s�[�v���u�ԃ|�[�V�����v��";
		//payon�̎���3�Ԗڂ̑I�����o�Ȃ�
		set '@i,select("�u"+getitemname('@need[0])+"�v���u�ԃ|�[�V�����v��","�u"+getitemname('@need[1])+"�v���u�ԃ|�[�V�����v��",'@talk$,"��߂Ă����܂�")-1;
		if('@i==3) {
			mes "[���l]";
			mes "�������c�c";
			mes "�܂��A�C����������܂����ȁB";
			close;
		}
		set '@have,countitem('@need['@i]);	//�����A�C�e��������
		if('@have < '@amount['@i]) {
			mes "[���l]";
			if('@code < 4 || '@i > 0)		//�t�F�C�����Ŗ؂̍���I�񂾏ꍇ�͕\������Ȃ��B(���̒n��͖�����)
				mes "�����I";
			mes getitemname('@need['@i])+ "�͂ǂ��ɂ���񂾁H";
			mes "������Ȃ�ł�" +getitemname('@need['@i])+ "��" +'@amount['@i]+ "�Ȃ���";
			mes "�ԃ|�[�V�����͓n���Ȃ����B";
			close;
		}
		mes "[���l]";
		mes "���肪�Ă��I";
		mes "���ꂶ��A���������悤���H";
		mes "���傢�ƌ����Ă݂ȁB";
		next;
		set '@max,'@have / '@amount['@i];	//�����\��
		mes "[���l]";
		mes getitemname('@need['@i])+ "��" +'@have+ "��";
		mes "����̂��c�c���������";
		mes "�ԃ|�[�V������" +'@max+ "�܂�";
		mes "�����ł��邼�B";
		next;
		mes "[���l]";
		mes getitemname('@need['@i])+ "��ԃ|�[�V�����ƌ������邩�H";
		next;
		if(select("�������܂�","����ς��߂Ă����܂�")==2) {
			mes "[���l]";
			mes "�c�c�d���˂��ȁB";
			mes "�܂��A�C���������痈�Ă����B";
			close;
		}
		mes "[���l]";
		mes "�ԃ|�[�V�����͍ő剽���炦�邩��";
		mes "����������������A�킩���Ă�ȁH";
		next;
		mes "[���l]";
		mes "��x�Ɍ����ł���ԃ|�[�V�����̐���";
		mes "�ŏ���1�A�ő��100���B";
		mes "������������C���Ȃ��Ȃ�u0�v��";
		mes "�����Ă���B";
		while(1) {
			next;
			input '@val;
			if('@val<0 || '@val>100) {
				mes "[���l]";
				mes "��x�Ɍ����ł���̂�";
				mes "100�܂ł����Č���������I";
				mes "�d���˂��ȁA������񕷂��Ă��B";
				mes "���ɂ���񂾁H";
				continue;
			}
			break;
		}
		if('@val == 0) {
			mes "[���l]";
			mes "���������A�����Ȃ�����B";
			mes "���҂����邾�������Ă����āc�c";
			mes "�d���˂��ȁB�C����������";
			mes "�܂����Ă����B";
			close;
		}
		if('@val > '@max) {
			mes "[���l]";
			mes "�����I���ꂶ�Ⴀ�A" +getitemname('@need['@i])+ "��";
			mes "����Ȃ�����H�ԃ|�[�V������";
			mes "���܂Ō����ł��邩�A�������";
			mes "�m�F���Ă��痈����B";
			close;
		}
		delitem '@need['@i],'@amount['@i]*'@val;
		getitem 501,'@val;
		mes "[���l]";
		mes "�����I���ꂪ�ԃ|�[�V�������B";
		mes "�m�F���Ă���B���肪�Ƃ�B";
		mes "���͂́[�I";
		close;
	case 2:
		mes "[���l]";
		mes "�����Ă邩�������āH���͂́[�B";
		mes "�S�R����Ȃ��Ƃ͂Ȃ��͂������B";
		mes "�ǂ��炩�ƌ����΁A���̕���";
		mes "���ɂȂ�B�܂��A���̏�����";
		mes "�C�ɂ���Ȃ��Ȃ�d���Ȃ����B";
		close;
	case 3:
		mes "[���l]";
		mes "�c�c�`�b�B�d���˂��ȁB";
		mes "�܂��C���������痈�Ă����B";
		close;
	}
}

prontera.gat,123,102,5	duplicate(NoviceExchange)	���l::NoviceExchange#0	85
geffen.gat,173,88,5	duplicate(NoviceExchange)	���l::NoviceExchange#1	85
morocc.gat,180,259,3	duplicate(NoviceExchange)	���l::NoviceExchange#2	85
aldebaran.gat,152,63,5	duplicate(NoviceExchange)	���l::NoviceExchange#3	85
payon.gat,200,134,5	duplicate(NoviceExchange)	���l::NoviceExchange#4	85


//�y���b�N�X
//  �� @change_jellopy

alberta.gat,190,173,3	script	�y���b�N�X	85,{
	if(@change_jellopy == 0) {
		mes "[�y���b�N�X]";
		mes "�Ȃ񂾁A���ɉ����p���H";
		mes "�����畨�~�������Ȋ炵������";
		mes "�������񂼁B";
		next;
		mes "[�y���b�N�X]";
		mes "�����~�����Ȃ�d��������A�d�����I";
		mes "��H�d�����Ȃ������āH";
		mes "�d���˂��ȁc�c";
		next;
		mes "[�y���b�N�X]";
		mes "���Ⴀ�A�[���s�[��10�W�߂Ă����B";
		mes "������ƏW�߂Ă����炻�̕�V�Ƃ���";
		mes "�ԃ|�[�V��������낤�B";
		next;
		mes "[�y���b�N�X]";
		mes "10�������Ȃ�A3�ł��������B";
		mes "�[���s�[��3�W�߂Ă�����";
		mes "��������낤�B";
		next;
		mes "[�y���b�N�X]";
		mes "�[���s�[����ɓ��ꂽ��";
		mes "�܂������ɗ��ȁB";
		if(countitem(909))
			set @change_jellopy,1;
		close;
	}
	mes "[�y���b�N�X]";
	mes "�����A�[���s�[���W�߂Ă����̂��B";
	mes "�悵�I�ԃ|�[�V����������";
	mes "�ǂ����ƌ�������񂾁H";
	next;
	switch (select("�ԃ|�[�V��������������","��������������")) {
		case 1:
			set '@amount,10;
			set '@gain,501;
			break;
		case 2:
			set '@amount,3;
			set '@gain,516;
			break;
	}
	mes "[�y���b�N�X]";
	mes "�킩�����B���Ⴀ�A�����Ă�������";
	mes "�����Ă���B";
	next;
	if(countitem(909) < '@amount) {
		mes "[�y���b�N�X]";
		mes "�����I" +getitemname('@gain)+ "���~����������";
		mes "�[���s�[��" +'@amount+ "�W�߂Ă�����";
		mes "����������H";
		close;
	}
	set '@max,countitem(909) / '@amount;	//�����\��
	mes "[�y���b�N�X]";
	mes "�悵�A" +getitemname('@gain)+ "�ƌ������Ă�낤�B";
	mes getitemname('@gain)+ "�͂����~�����񂾁H";
	next;
	switch (select("�ł������~�����ł�","�����w�肵�����ł�","����ς��߂Ă����܂�")) {
	case 1:
		set '@val,'@max;
		break;
	case 2:
		mes "[�y���b�N�X]";
		mes "�Ȃ�100�ȉ��ɂ��Ă���B";
		mes "������߂�Ȃ�u0�v�ƌ����΂����B";
		mes "���O�̎����Ă鐔���Ɓc�c";
		mes "�ő�" +'@max+ "�܂�";
		mes getitemname('@gain)+ "���������邼�B";
		while(1) {
			next;
			input '@val;
			if('@val < 0 || '@val > 100) {
				mes "[�y���b�N�X]";
				mes "100��葽���Ɠn���Ȃ�����B";
				mes "������x�l���Ă���B";
				continue;
			}
			break;
		}
		if('@val == 0) {
			mes "[�y���b�N�X]";
			mes "�������B";
			mes "���Ⴀ�A�܂��C���������痈�ȁB";
			close;
		}
		if('@val > '@max) {
			mes "[�y���b�N�X]";
			mes "����H���ꂾ�ƃ[���s�[������Ȃ����B";
			mes "���������W�߂Ă��痈��񂾂ȁB";
			close;
		}
		break;
	case 3:
		mes "[�y���b�N�X]";
		mes "���Ⴀ�A�܂����x�ȁB";
		close;
	}
	delitem 909,'@amount*'@val;
	getitem '@gain,'@val;
	mes "[�y���b�N�X]";
	mes "�ق��I";
	mes "�񑩂�" +getitemname('@gain)+ "���B";
	mes "�厖�Ɏg���񂾂��B";
	close;
}