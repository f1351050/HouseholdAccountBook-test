package com.uhablog.processor;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhablog.model.Receipt_infoModel;
import com.uhablog.repository.Receipt_infoRepository;

import lombok.RequiredArgsConstructor;

/*ファイル名から文字列を抽出する際に起こるエラー原因
 *①アンダーバー"_"が存在しないファイル名　例:店舗名金額(ファミマ203)
 *②日付が"(レシート日付)"と表示されているファイル名
 *
 *（想定されるエラー[まだ起こった起こったことはない])
 *①店舗名・金額が正しく表示されていない
 *
 */

@Service
@RequiredArgsConstructor
public class Receipt_infoExtraction{
	
	private final Receipt_infoRepository repository;
	
	public boolean process(){

		String path = "C:\\Users\\f1351\\Desktop\\レシート\\レシート";
		File file = new File(path);
		File files[] = file.listFiles();
		int count = 0;
		
		for(File f :files) {
			
			String file_name = f.getName().replace(".pdf", "");
			String string_date = file_name.substring(0,8);

			try {
				if(count != 0) {
					return true;
				}
				String tempo = file_name.substring(9,file_name.lastIndexOf("_"));
				String string_kingaku = file_name.substring(file_name.lastIndexOf("_")+1,file_name.length());
				int kingaku = Integer.parseInt(string_kingaku);
				System.out.println(string_date+"/"+tempo+"/"+kingaku);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Date date = sdf.parse(string_date);
				
				insert(date,tempo,kingaku);
				count++;

			//Date型変換の際に起こるエラー(原因②）	
			}catch(ParseException e) {
				//System.out.println(file_name);
				e.printStackTrace();
				continue;
				
			//アンダーバーが存在しない　際に起こるエラー(原因①）
			}catch(StringIndexOutOfBoundsException e) {
				char[] ary = file_name.toCharArray();
				int index_count = -1;
				int kingaku = 0;
				for(char a : ary) {
					index_count++;
					if(index_count < 9) {
						continue;
					}
					if(Character.isDigit(a)) {
						kingaku += a;
					}
				}
				//System.out.println("test");
				//System.out.println(file_name);
				e.printStackTrace();
				continue;
			}
			
		}
		return true;
	}
	
	@Transactional
	public void insert(Date date,String tempo,int kingaku ) {
		
		Receipt_infoModel model = new Receipt_infoModel(date,tempo,kingaku);
		repository.save(model);
		
	}
}
